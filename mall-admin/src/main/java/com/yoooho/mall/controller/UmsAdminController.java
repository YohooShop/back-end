package com.yoooho.mall.controller;

import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.yoooho.mall.bo.AdminUserDetails;
import com.yoooho.mall.common.utils.RedisUtils;
import com.yoooho.mall.dto.UmsAdminLoginParam;
import com.yoooho.mall.dto.UmsAdminParam;
import com.yoooho.mall.dto.UpdateAdminEmailParam;
import com.yoooho.mall.dto.UpdateAdminPasswordParam;
import com.yoooho.mall.common.CommonPage;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.common.utils.SecurityUtils;
import com.yoooho.mall.common.utils.YshopConstant;
import com.yoooho.mall.domian.VerificationCode;
import com.yoooho.mall.model.UmsAdmin;
import com.yoooho.mall.model.UmsPermission;
import com.yoooho.mall.model.UmsRole;
import com.yoooho.mall.service.VerificationCodeService;
import com.yoooho.mall.service.UmsAdminService;
import com.wf.captcha.ArithmeticCaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 后台用户管理
 * Created by yoooho on 2019/4/26.
 */
@Controller
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController {
    @Value("${rsa.private_key}")
    private String privateKey;
    @Value("${loginCode.expiration}")
    private Long expiration;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private VerificationCodeService verificationCodeService;
    @Autowired
    private UmsAdminService adminService;

    @Autowired
    private RedisUtils redisUtils;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UserDetailsService userDetailsService;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<UmsAdmin> register(@RequestBody UmsAdminParam umsAdminParam, BindingResult result) {
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin == null) {
            CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/code/{uuid}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getCode(@PathVariable String uuid){
        // 算术类型 https://gitee.com/whvse/EasyCaptcha
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(111, 36);
        // 几位数运算，默认是两位
        captcha.setLen(2);
        // 获取运算的结果
        String result = captcha.text();
//        String uuid = properties.getCodeKey() + IdUtil.simpleUUID();
        //  保存
        redisUtils.set(uuid, result, expiration, TimeUnit.MINUTES);
        // 验证码信息
        Map<String,Object> imgResult = new HashMap<String,Object>(2){{
            put("img", captcha.toBase64());
//            put("uuid", uuid);
        }};
        return CommonResult.success(imgResult);
    }
    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {

        if(umsAdminLoginParam.getUuid() == null) {
            CommonResult.failed("非法请求");
        }
        // 查询验证码
        String code = (String) redisUtils.get(umsAdminLoginParam.getUuid());
        // 清除验证码
        redisUtils.del(umsAdminLoginParam.getUuid());
        //校验code
        if (StringUtils.isBlank(code)) {
            return CommonResult.failed("验证码不存在或已过期");
        }

        if (umsAdminLoginParam.getCode() == null || StringUtils.isBlank(umsAdminLoginParam.getCode()) || !umsAdminLoginParam.getCode().equalsIgnoreCase(code)) {
            return CommonResult.failed("验证码错误");
        }
        RSA rsa = new RSA(privateKey, null);
        umsAdminLoginParam.setPassword(new String(rsa.decrypt(umsAdminLoginParam.getPassword(), KeyType.PrivateKey)));
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "刷新token")
    @RequestMapping(value = "/token/refresh", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = adminService.refreshToken(token);
        if (refreshToken == null) {
            return CommonResult.failed();
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAdminInfo(Principal principal) {
        AdminUserDetails umsAdmin = (AdminUserDetails) userDetailsService.loadUserByUsername(SecurityUtils.getUsername());
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "更新当前登录用户信息")
    @RequestMapping(value = "/update/info", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateAdminInfo(  @RequestBody UmsAdminParam  adminParam) {

        UmsAdmin umsAdmin = adminService.getCurrentAdmin();
        umsAdmin.setNickName(adminParam.getNickName());
        umsAdmin.setPhone(adminParam.getPhone());
        umsAdmin.setSex(adminParam.getSex());
        umsAdmin.setEmail(adminParam.getEmail());
        umsAdmin.setIcon(adminParam.getIcon());
        int count = adminService.update(umsAdmin.getId(), umsAdmin);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "修改密码")
    @RequestMapping(value = "/updateMinePassword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateMinePassword(@RequestBody UpdateAdminPasswordParam updatePasswordParam) {
        RSA rsa = new RSA(privateKey, null);
      UmsAdmin admin = adminService.getCurrentAdmin();
      updatePasswordParam.setUsername(admin.getUsername());
      updatePasswordParam.setOldPassword(new String(rsa.decrypt(updatePasswordParam.getOldPassword(), KeyType.PrivateKey)));
        updatePasswordParam.setNewPassword(new String(rsa.decrypt(updatePasswordParam.getNewPassword(), KeyType.PrivateKey)));
        int status = adminService.updatePassword(updatePasswordParam);
        if (status > 0) {
            return CommonResult.success(status);
        } else if (status == -1) {
            return CommonResult.failed("提交参数不合法");
        } else if (status == -2) {
            return CommonResult.failed("找不到该用户");
        } else if (status == -3) {
            return CommonResult.failed("旧密码错误");
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改邮箱")
    @PostMapping(value = "/updateEmail")
    @ResponseBody
    public CommonResult updateEmail(@RequestBody UpdateAdminEmailParam emailParam){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        // 密码解密
        RSA rsa = new RSA(privateKey, null);
        String password = new String(rsa.decrypt(emailParam.getPassword(), KeyType.PrivateKey));
        UmsAdmin admin = adminService.getCurrentAdmin();
        String encodePassword = passwordEncoder.encode(password);
        if(!passwordEncoder.matches(password, admin.getPassword())){
            return  CommonResult.failed("密码错误");
        }
        VerificationCode verificationCode = new VerificationCode(emailParam.getCode(), YshopConstant.RESET_MAIL,"email",emailParam.getEmail());
        boolean sucess = verificationCodeService.validated(verificationCode);
        if (!sucess) {
            return CommonResult.failed("验证码错误");
        }else {

        }
        int res = adminService.updateEmail(emailParam.getEmail());
        if (res == 0){
            return CommonResult.success("修改邮箱失败");
        }else {
            return CommonResult.success("修改邮箱成功");
        }

    }
    @ApiOperation(value = "登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult logout() {
        return CommonResult.success(null);
    }

    @ApiOperation("根据用户名或姓名分页获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<UmsAdmin>> list(@RequestParam(value = "name", required = false) String name,
                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UmsAdmin> adminList = adminService.list(name, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(adminList));
    }

    @ApiOperation("获取指定用户信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<UmsAdmin> getItem(@PathVariable Long id) {
        UmsAdmin admin = adminService.getItem(id);
        return CommonResult.success(admin);
    }

    @ApiOperation("修改指定用户信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody UmsAdmin admin) {
        int count = adminService.update(id, admin);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改指定用户密码")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword(@RequestBody UpdateAdminPasswordParam updatePasswordParam) {
        int status = adminService.updatePassword(updatePasswordParam);
        if (status > 0) {
            return CommonResult.success(status);
        } else if (status == -1) {
            return CommonResult.failed("提交参数不合法");
        } else if (status == -2) {
            return CommonResult.failed("找不到该用户");
        } else if (status == -3) {
            return CommonResult.failed("旧密码错误");
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除指定用户信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = adminService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("给用户分配角色")
    @RequestMapping(value = "/role/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateRole(@RequestParam("adminId") Long adminId,
                                   @RequestParam("roleIds") List<Long> roleIds) {
        int count = adminService.updateRole(adminId, roleIds);
        if (count >= 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取指定用户的角色")
    @RequestMapping(value = "/role/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsRole>> getRoleList(@PathVariable Long adminId) {
        List<UmsRole> roleList = adminService.getRoleList(adminId);
        return CommonResult.success(roleList);
    }

    @ApiOperation("给用户分配+-权限")
    @RequestMapping(value = "/permission/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePermission(@RequestParam Long adminId,
                                         @RequestParam("permissionIds") List<Long> permissionIds) {
        int count = adminService.updatePermission(adminId, permissionIds);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取用户所有权限（包括+-权限）")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsPermission>> getPermissionList(@PathVariable Long adminId) {
        List<UmsPermission> permissionList = adminService.getPermissionList(adminId);
        return CommonResult.success(permissionList);
    }

}
