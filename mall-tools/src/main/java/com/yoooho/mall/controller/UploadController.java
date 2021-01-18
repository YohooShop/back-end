package com.yoooho.mall.controller;

import cn.hutool.core.util.StrUtil;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.domian.AliyunossConfig;

import com.yoooho.mall.domian.AliyunOssContent;
import com.yoooho.mall.service.AliyunOSSService;
import com.yoooho.mall.service.LocalStorageService;
import com.yoooho.mall.service.dto.LocalStorageDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hupeng
 * @date 2020-01-09
 */
@Api(tags = "上传统一管理")
@RestController
@RequestMapping("/api/upload")
@CrossOrigin
@SuppressWarnings("unchecked")
public class UploadController {

    @Value("${file.localUrl}")
    private String localUrl;

    @Autowired
    private LocalStorageService localStorageService;

    @Autowired
    private AliyunOSSService aliyunOSSService;



    @ApiOperation("上传文件")
    @PostMapping
//    @AnonymousAccess
    @ResponseBody
    public CommonResult create(@RequestParam(defaultValue = "") String name, @RequestParam("file") MultipartFile file){
        String url = "";
        if(StrUtil.isNotEmpty(localUrl)){ //存在走本地
            LocalStorageDTO localStorageDTO = localStorageService.create(name, file);
            url = localUrl+"/file/"+localStorageDTO.getType()+"/"+localStorageDTO.getRealName();
        }else{//走七牛云
            AliyunOssContent content = null;
            AliyunossConfig config = null;
            try {
                config = (AliyunossConfig) aliyunOSSService.find();
                content  = (AliyunOssContent) aliyunOSSService.upload(file,config);
                String http = "http://", https = "https://";
                if (config.getHost()!= null && (config.getHost().toLowerCase().startsWith(http) || config.getHost().toLowerCase().startsWith(https))) {
                    url = config.getHost() + "/"+ content.getUrl() ;
                }else {
                    url = https +config.getEndpoint() + "/"+ content.getUrl() ;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        Map<String, Object> map = new HashMap<>(2);
        map.put("errno",0);
        map.put("link",url);
        return CommonResult.success(map);
    }



}
