package com.yoooho.mall.controller;

import cn.hutool.core.date.DateUtil;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.dto.WechatArticleQueryCriteria;
import com.yoooho.mall.model.WechatArticle;
import com.yoooho.mall.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Api(tags = "商城:微信图文管理")
@RestController
@RequestMapping("api/wechat")
public class WechatArticleController {
    @Autowired
    private ArticleService articleService;
    @ApiOperation(value = "查询")
    @GetMapping(value = "/article")
    //@PreAuthorize("@el.check('admin','YXARTICLE_ALL','YXARTICLE_SELECT')")
    public CommonResult getArticles(Pageable pageable){
        return CommonResult.success(articleService.queryAll(pageable));
    }
    @ApiOperation(value = "查询")
    @GetMapping(value = "/articleList")
    //@PreAuthorize("@el.check('admin','YXARTICLE_ALL','YXARTICLE_SELECT')")
    public CommonResult getArticles( Pageable pageable, WechatArticleQueryCriteria criteria){
        return CommonResult.success(articleService.queryAll(criteria,pageable));
    }
    @ApiOperation(value = "新增")
    @PostMapping(value = "/article")
//    @PreAuthorize("@el.check('admin','YXARTICLE_ALL','YXARTICLE_CREATE')")
    public CommonResult create(@Validated @RequestBody WechatArticle resources) throws Exception{
        resources.setAddTime(DateUtil.format(new Date(),"yyyy-MM-dd HH:mm"));
        return CommonResult.success(articleService.create(resources));
    }

    @ApiOperation(value = "修改")
    @PutMapping(value = "/article")
//    @PreAuthorize("@el.check('admin','YXARTICLE_ALL','YXARTICLE_EDIT')")
    public  CommonResult update(@Validated @RequestBody WechatArticle resources) throws Exception{
        articleService.update(resources);
        return CommonResult.success("");
    }


    @ApiOperation(value = "删除")
    @DeleteMapping(value = "/article/{id}")
//    @PreAuthorize("@el.check('admin','YXARTICLE_ALL','YXARTICLE_DELETE')")
    public CommonResult delete(@PathVariable Integer id){
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        articleService.delete(id);
        return CommonResult.success("");
    }

    @ApiOperation(value = "发布文章")
    @GetMapping(value = "/article/publish/{id}")
  //  @PreAuthorize("@el.check('admin','YXARTICLE_ALL','YXARTICLE_DELETE')")
    public CommonResult publish(@PathVariable Integer id)  throws Exception{
        //if(StrUtil.isNotEmpty("22")) throw new BadRequestException("演示环境禁止操作");
        WechatArticle article= articleService.findById(id);
        return  articleService.uploadNews(article);
    }


}
