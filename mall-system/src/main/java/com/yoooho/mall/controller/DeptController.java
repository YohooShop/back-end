package com.yoooho.mall.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.domain.Dept;
import com.yoooho.mall.config.DataScope;
import com.yoooho.mall.service.DeptService;
import com.yoooho.mall.service.dto.DeptDTO;
import com.yoooho.mall.service.dto.DeptQueryCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@Api(tags = "系统：部门管理")
@RequestMapping("/api/dept")
public class DeptController {

    private final DeptService deptService;

    private final DataScope dataScope;

    private static final String ENTITY_NAME = "dept";

    public DeptController(DeptService deptService, DataScope dataScope) {
        this.deptService = deptService;
        this.dataScope = dataScope;
    }


    @ApiOperation("导出部门数据")
    @GetMapping(value = "/download")
    @ResponseBody
    @PreAuthorize("@el.check('admin','dept:list')")
    public void download(HttpServletResponse response, DeptQueryCriteria criteria) throws IOException {
        deptService.download(deptService.queryAll(criteria), response);
    }

    @ApiOperation("查询部门")
    @GetMapping
    @ResponseBody
    @PreAuthorize("@el.check('user:list','admin','dept:list')")
    public CommonResult getDepts(DeptQueryCriteria criteria) {
        // 数据权限
        criteria.setIds(dataScope.getDeptIds());
        List<DeptDTO> deptDtos = deptService.queryAll(criteria);
        return CommonResult.success(deptService.buildTree(deptDtos));
    }


    @ApiOperation("新增部门")
    @PostMapping
    @ResponseBody
    @PreAuthorize("@el.check('admin','dept:add')")
    public CommonResult create(@Validated @RequestBody Dept resources) {
        if (resources.getId() != null) {
            CommonResult.failed("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return CommonResult.success(deptService.create(resources));
    }

    @ApiOperation("修改部门")
    @PutMapping
    @ResponseBody
    @PreAuthorize("@el.check('admin','dept:edit')")
    public CommonResult  update(@Validated(Dept.Update.class) @RequestBody Dept resources) {
        deptService.update(resources);
        return CommonResult.success("");
    }


    @ApiOperation("删除部门")
    @DeleteMapping
    @ResponseBody
    @PreAuthorize("@el.check('admin','dept:del')")
    public CommonResult  delete(@RequestBody Set<Long> ids) {
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        Set<DeptDTO> deptDtos = new HashSet<>();
        for (Long id : ids) {
            List<Dept> deptList = deptService.findByPid(id);
            deptDtos.add(deptService.findById(id));
            if (CollectionUtil.isNotEmpty(deptList)) {
                deptDtos = deptService.getDeleteDepts(deptList, deptDtos);
            }
        }
        try {
            deptService.delete(deptDtos);
        } catch (Throwable e) {
            return CommonResult.failed();
            //ThrowableUtil.throwForeignKeyException(e, "所选部门中存在岗位或者角色关联，请取消关联后再试");
        }
        return CommonResult .success("");
    }
}
