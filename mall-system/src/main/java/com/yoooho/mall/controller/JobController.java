package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.config.DataScope;
import com.yoooho.mall.domain.Job;
import com.yoooho.mall.service.JobService;
import com.yoooho.mall.service.dto.JobQueryCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Api(tags = "系统：岗位管理")
@RestController
@RequestMapping("/api/job")
public class JobController {

    private final JobService jobService;

    private final DataScope dataScope;

    private static final String ENTITY_NAME = "job";

    public JobController(JobService jobService, DataScope dataScope) {
        this.jobService = jobService;
        this.dataScope = dataScope;
    }

    @ApiOperation("导出岗位数据")
    @GetMapping(value = "/download")
    @ResponseBody
   // @PreAuthorize("@el.check('admin','job:list')")
    public void download(HttpServletResponse response, JobQueryCriteria criteria) throws IOException {
        jobService.download(jobService.queryAll(criteria), response);
    }

    @ApiOperation("查询岗位")
    @GetMapping
    @ResponseBody
   // @PreAuthorize("@el.check('admin','job:list','user:list')")
    public CommonResult getJobs(JobQueryCriteria criteria, Pageable pageable){
        // 数据权限
        criteria.setDeptIds(dataScope.getDeptIds());
        return CommonResult.success(jobService.queryAll(criteria, pageable));
    }

    @ApiOperation("新增岗位")
    @PostMapping
    @ResponseBody
   // @PreAuthorize("@el.check('admin','job:add')")
    public CommonResult create(@Validated @RequestBody Job resources){
        if (resources.getId() != null) {
            return CommonResult.failed("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return CommonResult.success(jobService.create(resources));
    }

    @ApiOperation("修改岗位")
    @PutMapping
    @ResponseBody
    //@PreAuthorize("@el.check('admin','job:edit')")
    public CommonResult update(@Validated(Job.Update.class) @RequestBody Job resources){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        jobService.update(resources);
        return CommonResult.success("");
    }

    @ApiOperation("删除岗位")
    @DeleteMapping
   // @PreAuthorize("@el.check('admin','job:del')")
    public CommonResult delete(@RequestBody Set<Long> ids){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        try {
            jobService.delete(ids);
        }catch (Throwable e){
            return CommonResult.failed("所选岗位存在用户关联，请取消关联后再试");
        }
        return CommonResult.success("");
    }
}
