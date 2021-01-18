package com.yoooho.mall.controller;


import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.common.exception.BadRequestException;
import com.yoooho.mall.common.utils.PageUtil;
import com.yoooho.mall.common.utils.SecurityUtils;
import com.yoooho.mall.config.DataScope;
import com.yoooho.mall.domain.User;
import com.yoooho.mall.service.DeptService;
import com.yoooho.mall.service.RoleService;
import com.yoooho.mall.service.UserService;
import com.yoooho.mall.service.VerificationCodeService;
import com.yoooho.mall.service.dto.RoleSmallDTO;
import com.yoooho.mall.service.dto.UserDTO;
import com.yoooho.mall.service.dto.UserQueryCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Zheng Jie
 * @date 2019-11-23
 */
@Api(tags = "系统：用户管理")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Value("${rsa.private_key}")
    private String privateKey;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final DataScope dataScope;
    private final DeptService deptService;
    private final RoleService roleService;
    private final VerificationCodeService verificationCodeService;

    public UserController(PasswordEncoder passwordEncoder, UserService userService, DataScope dataScope, DeptService deptService, RoleService roleService, VerificationCodeService verificationCodeService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.dataScope = dataScope;
        this.deptService = deptService;
        this.roleService = roleService;
        this.verificationCodeService = verificationCodeService;
    }


    @ApiOperation("导出用户数据")
    @GetMapping(value = "/download")
    //@PreAuthorize("@el.check('admin','user:list')")
    public void download(HttpServletResponse response, UserQueryCriteria criteria) throws IOException {
        userService.download(userService.queryAll(criteria), response);
    }


    @ApiOperation("查询用户")
    @GetMapping
    @ResponseBody
    //@PreAuthorize("@el.check('admin','user:list')")
    public CommonResult getUsers(UserQueryCriteria criteria, Pageable pageable){
        Set<Long> deptSet = new HashSet<>();
        Set<Long> result = new HashSet<>();
        if (!ObjectUtils.isEmpty(criteria.getDeptId())) {
            deptSet.add(criteria.getDeptId());
            deptSet.addAll(dataScope.getDeptChildren(deptService.findByPid(criteria.getDeptId())));
        }
        // 数据权限
        Set<Long> deptIds = dataScope.getDeptIds();
        // 查询条件不为空并且数据权限不为空则取交集
        if (!CollectionUtils.isEmpty(deptIds) && !CollectionUtils.isEmpty(deptSet)){
            // 取交集
            result.addAll(deptSet);
            result.retainAll(deptIds);
            // 若无交集，则代表无数据权限
            criteria.setDeptIds(result);
            if(result.size() == 0){
                return CommonResult.success(PageUtil.toPage(null,0));
            } else {
                return CommonResult.success(userService.queryAll(criteria,pageable));
            }
        // 否则取并集
        } else {
            result.addAll(deptSet);
            result.addAll(deptIds);
            criteria.setDeptIds(result);
            return CommonResult.success(userService.queryAll(criteria,pageable));
        }
    }

    @ApiOperation("新增用户")
    @PostMapping
    @ResponseBody
//    @PreAuthorize("@el.check('admin','user:add')")
    public CommonResult create(@Validated @RequestBody User resources){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        checkLevel(resources);
        // 默认密码 123456
        resources.setPassword(passwordEncoder.encode("123456"));
        return CommonResult.success(userService.create(resources));
    }

    @ApiOperation("修改用户")
    @PutMapping
    @ResponseBody
//    @PreAuthorize("@el.check('admin','user:edit')")
    public CommonResult updateUser(@Validated(User.Update.class) @RequestBody User resources){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        checkLevel(resources);
        userService.update(resources);
        return CommonResult.success("");
    }

    @ApiOperation("修改用户：个人中心")
    @PutMapping(value = "center")
    @ResponseBody
    public CommonResult center(@Validated(User.Update.class) @RequestBody User resources){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        UserDTO userDto = userService.findByName(SecurityUtils.getUsername());
        if(!resources.getId().equals(userDto.getId())){
            return CommonResult.failed("不能修改他人资料");
        }
        userService.updateCenter(resources);
        return CommonResult.success("");
    }

    @ApiOperation("删除用户")
    @DeleteMapping
//    @PreAuthorize("@el.check('admin','user:del')")
    @ResponseBody
    public CommonResult delete(@RequestBody Set<Long> ids){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        UserDTO user = userService.findByName(SecurityUtils.getUsername());
        for (Long id : ids) {
            Integer currentLevel =  Collections.min(roleService.findByUsersId(user.getId()).stream().map(RoleSmallDTO::getLevel).collect(Collectors.toList()));
            Integer optLevel =  Collections.min(roleService.findByUsersId(id).stream().map(RoleSmallDTO::getLevel).collect(Collectors.toList()));
            if (currentLevel > optLevel) {
                return CommonResult.failed("角色权限不足，不能删除：" + userService.findByName(SecurityUtils.getUsername()).getUsername());
            }
        }
        userService.delete(ids);
        return CommonResult.success("");
    }



    @ApiOperation("修改头像")
    @PostMapping(value = "/updateAvatar")
    @ResponseBody
    public ResponseEntity<Object> updateAvatar(@RequestParam MultipartFile file){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        userService.updateAvatar(file);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * 如果当前用户的角色级别低于创建用户的角色级别，则抛出权限不足的错误
     * @param resources /
     */
    private void checkLevel(User resources) {
        UserDTO user = userService.findByName(SecurityUtils.getUsername());
        Integer currentLevel =  Collections.min(roleService.findByUsersId(user.getId()).stream().map(RoleSmallDTO::getLevel).collect(Collectors.toList()));
        Integer optLevel = roleService.findByRoles(resources.getRoles());
        if (currentLevel > optLevel) {

            throw new BadRequestException("角色权限不足");
        }
    }
}
