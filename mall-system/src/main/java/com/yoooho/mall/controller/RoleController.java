package com.yoooho.mall.controller;

import cn.hutool.core.lang.Dict;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.common.exception.BadRequestException;
import com.yoooho.mall.common.utils.SecurityUtils;
import com.yoooho.mall.domain.Role;
import com.yoooho.mall.service.RoleService;
import com.yoooho.mall.service.UserService;
import com.yoooho.mall.service.dto.RoleDTO;
import com.yoooho.mall.service.dto.RoleQueryCriteria;
import com.yoooho.mall.service.dto.RoleSmallDTO;
import com.yoooho.mall.service.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Api(tags = "系统：角色管理")
@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;
    private final UserService userService;

    private static final String ENTITY_NAME = "role";

    public RoleController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @ApiOperation("获取单个role")
    @GetMapping(value = "/{id}")
    @ResponseBody
//    @PreAuthorize("@el.check('roles:list')")
    public CommonResult getRoles(@PathVariable Long id){
        return CommonResult.success(roleService.findById(id));
    }


    @ApiOperation("导出角色数据")
    @GetMapping(value = "/download")
//    @PreAuthorize("@el.check('role:list')")
    public void download(HttpServletResponse response, RoleQueryCriteria criteria) throws IOException {
        roleService.download(roleService.queryAll(criteria), response);
    }

    @ApiOperation("返回全部的角色")
    @GetMapping(value = "/all")
    @ResponseBody
    //@PreAuthorize("@el.check('roles:list','user:add','user:edit')")
    public CommonResult getAll(@PageableDefault(value = 2000, sort = {"level"}, direction = Sort.Direction.ASC) Pageable pageable){
        return CommonResult.success(roleService.queryAll(pageable)) ;
    }


    @ApiOperation("查询角色")
    @GetMapping
    @ResponseBody
   // @PreAuthorize("@el.check('roles:list')")
    public CommonResult getRoles(RoleQueryCriteria criteria, Pageable pageable){
        return CommonResult.success(roleService.queryAll(criteria,pageable));
    }

    @ApiOperation("获取用户级别")
    @GetMapping(value = "/level")
    @ResponseBody
    public CommonResult getLevel(){
        return CommonResult.success(Dict.create().set("level", getLevels(null)));
    }

    @ApiOperation("新增角色")
    @PostMapping
  //  @PreAuthorize("@el.check('roles:add')")
    @ResponseBody
    public CommonResult create(@Validated @RequestBody Role resources){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        if (resources.getId() != null) {
            return CommonResult.failed("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        getLevels(resources.getLevel());
        return CommonResult.success(roleService.create(resources));
    }


    @ApiOperation("修改角色")
    @PutMapping
    @ResponseBody
   // @PreAuthorize("@el.check('roles:edit')")
    public CommonResult update(@Validated(Role.Update.class) @RequestBody Role resources){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        getLevels(resources.getLevel());
        roleService.update(resources);
        return CommonResult.success("");
    }


    @ApiOperation("修改角色菜单")
    @PutMapping(value = "/menu")
    @ResponseBody
    //@PreAuthorize("@el.check('roles:edit')")
    public CommonResult updateMenu(@RequestBody Role resources){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        RoleDTO role = roleService.findById(resources.getId());
        getLevels(role.getLevel());
        roleService.updateMenu(resources,role);
        return CommonResult.success("");
    }


    @ApiOperation("删除角色")
    @DeleteMapping
   // @PreAuthorize("@el.check('roles:del')")
    public CommonResult delete(@RequestBody Set<Long> ids){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        for (Long id : ids) {
            RoleDTO role = roleService.findById(id);
            getLevels(role.getLevel());
        }
        try {
            roleService.delete(ids);
        } catch (Throwable e){
            return CommonResult.failed("所选角色存在用户关联，请取消关联后再试");
        }
        return CommonResult.success("");
    }

    /**
     * 获取用户的角色级别
     * @return /
     */
    private int getLevels(Integer level){
        UserDTO user = userService.findByName(SecurityUtils.getUsername());
        List<Integer> levels = roleService.findByUsersId(user.getId()).stream().map(RoleSmallDTO::getLevel).collect(Collectors.toList());
        int min = Collections.min(levels);
        if(level != null){
            if(level < min){
                throw new BadRequestException("权限不足，你的角色级别：" + min + "，低于操作的角色级别：" + level);
            }
        }
        return min;
    }
}
