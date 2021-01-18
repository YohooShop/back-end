package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.common.utils.SecurityUtils;
import com.yoooho.mall.domain.Menu;
import com.yoooho.mall.service.MenuService;
import com.yoooho.mall.service.RoleService;
import com.yoooho.mall.service.UserService;
import com.yoooho.mall.service.dto.MenuDTO;
import com.yoooho.mall.service.dto.MenuQueryCriteria;
import com.yoooho.mall.service.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Zheng Jie
 * @date 2019-12-03
 */
@Api(tags = "系统：菜单管理")
@RestController
@RequestMapping("/api/menus")
@SuppressWarnings("unchecked")
public class MenuController {

    private final MenuService menuService;

    private final UserService userService;

    private final RoleService roleService;

    private static final String ENTITY_NAME = "menu";

    public MenuController(MenuService menuService, UserService userService, RoleService roleService) {
        this.menuService = menuService;
        this.userService = userService;
        this.roleService = roleService;
    }


    @ApiOperation("导出菜单数据")
    @GetMapping(value = "/download")
//    @PreAuthorize("@el.check('menu:list')")
    public void download(HttpServletResponse response, MenuQueryCriteria criteria) throws IOException {
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        menuService.download(menuService.queryAll(criteria), response);
    }

    @ApiOperation("获取前端所需菜单")
    @GetMapping(value = "/build")
    @ResponseBody
    public CommonResult buildMenus(){
        UserDTO user = userService.findByName(SecurityUtils.getUsername());
        List<MenuDTO> menuDtoList = menuService.findByRoles(roleService.findByUsersId(user.getId()));
        List<MenuDTO> menuDtos = (List<MenuDTO>) menuService.buildTree(menuDtoList).get("content");
        return CommonResult.success(menuService.buildMenus(menuDtos));
    }

    @ApiOperation("返回全部的菜单")
    @GetMapping(value = "/tree")
//    @PreAuthorize("@el.check('menu:list','roles:list')")
    public CommonResult getMenuTree(){
        return CommonResult.success(menuService.getMenuTree(menuService.findByPid(0L)));
    }


    @ApiOperation("查询菜单")
    @GetMapping
    @ResponseBody
//    @PreAuthorize("@el.check('menu:list')")
    public CommonResult getMenus(MenuQueryCriteria criteria){
        List<MenuDTO> menuDtoList = menuService.queryAll(criteria);
        return CommonResult.success(menuService.buildTree(menuDtoList));
    }

    @ApiOperation("新增菜单")
    @PostMapping
    @ResponseBody
//    @PreAuthorize("@el.check('menu:add')")
    public CommonResult create(@Validated @RequestBody Menu resources){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        if (resources.getId() != null) {
            return  CommonResult.failed("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        menuService.create(resources);
        return CommonResult.success("");
    }

    @ApiOperation("修改菜单")
    @PutMapping
    @ResponseBody
//    @PreAuthorize("@el.check('menu:edit')")
    public CommonResult update(@Validated(Menu.Update.class) @RequestBody Menu resources){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        menuService.update(resources);
        return CommonResult.success("");
    }


    @ApiOperation("删除菜单")
    @DeleteMapping
    @ResponseBody
//    @PreAuthorize("@el.check('menu:del')")
    public CommonResult delete(@RequestBody Set<Long> ids){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        Set<Menu> menuSet = new HashSet<>();
        for (Long id : ids) {
            List<Menu> menuList = menuService.findByPid(id);
            menuSet.add(menuService.findOne(id));
            menuSet = menuService.getDeleteMenus(menuList, menuSet);
        }
        menuService.delete(menuSet);
        return CommonResult.success("");
    }
}
