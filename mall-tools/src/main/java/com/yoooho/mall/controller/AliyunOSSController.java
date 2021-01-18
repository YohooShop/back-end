package com.yoooho.mall.controller;

import com.yoooho.mall.domian.AliyunOssContent;
import com.yoooho.mall.domian.AliyunossConfig;
import com.yoooho.mall.service.AliyunOSSService;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.service.dto.AliyunOssQueryCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/aliyunOssContent")
@Api(tags = "工具：阿里云存储管理")
public class AliyunOSSController {

    private final AliyunOSSService aliyunOSSService;

    public  AliyunOSSController(AliyunOSSService  aliyunOSSService) {
        this.aliyunOSSService = aliyunOSSService;
    }



    @GetMapping(value = "/config")
    @PreAuthorize("@el.check('tools:aliyunOss:config')")
    public CommonResult get(){
       return CommonResult.success(aliyunOSSService.find());
    }


    @ApiOperation("配置阿里云存储")
    @PutMapping(value = "/config")
    @PreAuthorize("@el.check('tools:aliyunOss:config')")
    public CommonResult  emailConfig(@Validated @RequestBody AliyunossConfig aliyunossConfig){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        // aliyunOSSService.update(aliyunossConfig);
//        qiNiuService.update(qiniuConfig.getType());
        return CommonResult.success(aliyunOSSService.update(aliyunossConfig));
    }

    @ApiOperation("上传文件")
    @PostMapping
    @ResponseBody
    @PreAuthorize("@el.check('tools:aliyunOss:upload')")
    public CommonResult upload(@RequestParam MultipartFile file) throws IOException {
        AliyunOssContent aliyunOssContent = (AliyunOssContent) aliyunOSSService.upload(file, (AliyunossConfig) aliyunOSSService.find());
        if (aliyunOssContent == null) {
            return CommonResult.failed();
        }
        Map<String,Object> map = new HashMap<>(3);
        map.put("id",aliyunOssContent.getId());
        map.put("errno",0);
        map.put("data",new String[]{aliyunOssContent.getUrl()});
        return CommonResult.success(map);
    }

    @ApiOperation("查询文件")
    @GetMapping
    @ResponseBody
    @PreAuthorize("@el.check('tools:aliyunOss:read')")
    public CommonResult getRoles(AliyunOssQueryCriteria criteria, Pageable pageable){
        return CommonResult.success(aliyunOSSService.queryAll(criteria,pageable));
    }

    @ApiOperation("同步阿里云数据")
    @PostMapping(value = "/synchronize")
    @ResponseBody
    @PreAuthorize("@el.check('tools:aliyunOss:synchronize')")
    public CommonResult synchronize(){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        aliyunOSSService.synchronize((AliyunossConfig) aliyunOSSService.find());
        return CommonResult.success("");
    }
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('tools:aliyunOss:download')")
    public void download(HttpServletResponse response, AliyunOssQueryCriteria criteria) throws IOException {
        aliyunOSSService.downloadList(aliyunOSSService.queryAll(criteria), response);
    }

    @ApiOperation("下载文件")
    @GetMapping(value = "/download/{id}")
    @ResponseBody
    public CommonResult download(@PathVariable Long id){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        Map<String,Object> map = new HashMap<>(1);
        map.put("url", aliyunOSSService.download(aliyunOSSService.findByContentId(id), (AliyunossConfig) aliyunOSSService.find()));
        if (map.get("url") == null) {
            return CommonResult.failed();
        }else {
            return CommonResult.success(map);
        }
    }

    @ApiOperation("删除文件")
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('tools:aliyunOss:del')")
    public CommonResult delete(@PathVariable Long id){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        aliyunOSSService.delete(aliyunOSSService.findByContentId(id), (AliyunossConfig) aliyunOSSService.find());
        return CommonResult.success("");
    }


    @ApiOperation("删除多张图片")
    @PreAuthorize("hasAuthority('tools:aliyunOss:del')")
    @DeleteMapping
    public CommonResult<String> deleteAll(@RequestBody Long[] ids) {
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        aliyunOSSService.deleteAll(ids, (AliyunossConfig) aliyunOSSService.find());
        return CommonResult.success("");
    }


}
