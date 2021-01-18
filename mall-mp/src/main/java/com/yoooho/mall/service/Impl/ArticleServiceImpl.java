package com.yoooho.mall.service.Impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.common.annotation.QueryHelp;
import com.yoooho.mall.common.utils.PageUtil;
import com.yoooho.mall.config.WxMpConfiguration;
import com.yoooho.mall.domian.WXArticle;
import com.yoooho.mall.dto.WechatArticleQueryCriteria;
import com.yoooho.mall.mapper.WechatArticleMapper;
import com.yoooho.mall.mapper.WechatArticleOriginMapper;
import com.yoooho.mall.model.WechatArticle;
import com.yoooho.mall.model.WechatArticleOrigin;
import com.yoooho.mall.repository.ArticleRepository;
import com.yoooho.mall.service.ArticleService;
import com.yoooho.mall.service.SystemConfigService;
import com.yoooho.mall.service.mapper.ArticleMapper;
import com.yoooho.mall.utils.JsonUtils;
import com.yoooho.mall.utils.URLUtils;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpMassTagMessage;
import me.chanjar.weixin.mp.bean.material.*;
import me.chanjar.weixin.mp.bean.result.WxMpMassSendResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ArticleServiceImpl implements ArticleService {

    @Value("${file.path}")
    private String uploadDirStr;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    WechatArticleMapper articleMapper;

    @Autowired
    SystemConfigService systemConfigService;

    @Autowired
    ArticleMapper articleMapper1;

    @Autowired
    WechatArticleOriginMapper articleOriginMapper;

    @Override
    public Map<String, Object> queryAll(Pageable pageable) {


        Page<WXArticle> page = articleRepository.findAll(pageable);
        return PageUtil.toPage(page);
    }

   public WxMpMaterialNews getMpMaterialNews(String mediaId) throws  WxErrorException{
        WxMpService wxMpService = WxMpConfiguration.getWxMpService(systemConfigService.queryWXOfficialAccountConfig());
        WxMpMaterialNews wxMpMaterialNews= wxMpService.getMaterialService().materialNewsInfo(mediaId);
       log.info(JsonUtils.toJson(wxMpMaterialNews));
       return wxMpMaterialNews;
    }

    @Override
    public WechatArticleOrigin getWechatArticleOrigin(String mediaId){
        return articleOriginMapper.selectByPrimaryKey(mediaId);
    }

    @Override
    public Map<String, Object> queryAll(WechatArticleQueryCriteria criteria, Pageable pageable) {
        Page<WXArticle> page = articleRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(articleMapper1::toDto));
    }

    @Override
    public WechatArticle findById(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public WechatArticle create(WechatArticle resources) throws WxErrorException {
        WxMpService wxMpService = WxMpConfiguration.getWxMpService(systemConfigService.queryWXOfficialAccountConfig());
        WxMpMaterialNews wxMpMaterialNews = getMaterialNews(resources);
        log.info( "wxMpMaterialNews : {}", JSONUtil.toJsonStr( wxMpMaterialNews ) );

        WxMpMaterialUploadResult wxMpMaterialUploadResult1 = wxMpService.getMaterialService()
                .materialNewsUpload( wxMpMaterialNews );
        wxMpMaterialNews=  getMpMaterialNews(wxMpMaterialUploadResult1.getMediaId());
        resources.setMediaId(wxMpMaterialUploadResult1.getMediaId());
        resources.setUrl(wxMpMaterialNews.getArticles().get(0).getUrl());
        articleMapper.insertSelective(resources);

        WechatArticleOrigin wechatArticleOrigin = new WechatArticleOrigin();
        wechatArticleOrigin.setAuthor(wxMpMaterialNews.getArticles().get(0).getAuthor());
        wechatArticleOrigin.setContent(wxMpMaterialNews.getArticles().get(0).getContent());
        wechatArticleOrigin.setContentSourceUrl(wxMpMaterialNews.getArticles().get(0).getContentSourceUrl());
        wechatArticleOrigin.setCreateTime(wxMpMaterialNews.getCreateTime());
        wechatArticleOrigin.setUpdateTime(wxMpMaterialNews.getUpdateTime());
        wechatArticleOrigin.setDigest(wxMpMaterialNews.getArticles().get(0).getDigest());
        wechatArticleOrigin.setMid(wxMpMaterialUploadResult1.getMediaId());
        wechatArticleOrigin.setThumbMediaId(wxMpMaterialNews.getArticles().get(0).getThumbMediaId());
        wechatArticleOrigin.setThumbUrl(wxMpMaterialNews.getArticles().get(0).getThumbUrl());
        wechatArticleOrigin.setOnlyFansCanComment(wxMpMaterialNews.getArticles().get(0).getOnlyFansCanComment());
        wechatArticleOrigin.setNeedOpenComment(wxMpMaterialNews.getArticles().get(0).getNeedOpenComment());
        wechatArticleOrigin.setTitle(wxMpMaterialNews.getArticles().get(0).getTitle());
        wechatArticleOrigin.setShowcCoverPic(wxMpMaterialNews.getArticles().get(0).isShowCoverPic());
        wechatArticleOrigin.setUrl(wxMpMaterialNews.getArticles().get(0).getUrl());
        articleOriginMapper.insertSelective(wechatArticleOrigin);
        return resources;
    }

   public  WxMpMaterialNews getMaterialNews(WechatArticle resources) throws WxErrorException {
        WxMpService wxMpService = WxMpConfiguration.getWxMpService(systemConfigService.queryWXOfficialAccountConfig());

        WxMpMaterialNews wxMpMaterialNews = new WxMpMaterialNews();
        WxMpMaterialNews.WxMpMaterialNewsArticle article = new WxMpMaterialNews.WxMpMaterialNewsArticle();
        WxMpMaterialUploadResult wxMpMaterialUploadResult = uploadPhotoToWx( wxMpService,
                resources.getImageInput() );
//        wechatArticle.setThumbMediaId( wxMpMaterialUploadResult.getMediaId() );

        article.setAuthor( resources.getAuthor() );


        //处理content
        String content = processContent(wxMpService, resources.getContent());
        System.out.println(content);
        article.setContent( content );
        article.setContentSourceUrl( resources.getUrl() );
        article.setDigest( resources.getSynopsis() );
        article.setShowCoverPic( true );
        article.setThumbMediaId(wxMpMaterialUploadResult.getMediaId());
        article.setTitle( resources.getTitle() );
        //TODO 暂时注释掉，测试号没有留言权限
        //article.setNeedOpenComment( wxNewsArticleItem );
        //article.setOnlyFansCanComment( wxNewsArticleItem );
        wxMpMaterialNews.addArticle( article );

        return wxMpMaterialNews;
    }

    @Override
    public void update(WechatArticle resources) throws WxErrorException {
        WxMpService wxMpService = WxMpConfiguration.getWxMpService(systemConfigService.queryWXOfficialAccountConfig());
        WxMpMaterialNews wxMpMaterialNews = getMaterialNews(resources);
        WxMpMaterialArticleUpdate articleUpdate = new WxMpMaterialArticleUpdate();
        articleUpdate.setArticles(wxMpMaterialNews.getArticles().get(0));
        if (resources.getMediaId() == null){
            resources = articleMapper.selectByPrimaryKey(resources.getId());
        }
        articleUpdate.setMediaId(resources.getMediaId());
        boolean b = wxMpService.getMaterialService().materialNewsUpdate(articleUpdate);

        if (b){
            articleMapper.updateByPrimaryKeySelective(resources);
            wxMpMaterialNews=  getMpMaterialNews(articleUpdate.getMediaId());
            WechatArticleOrigin wechatArticleOrigin = new WechatArticleOrigin();
            wechatArticleOrigin.setAuthor(wxMpMaterialNews.getArticles().get(0).getAuthor());
            wechatArticleOrigin.setContent(wxMpMaterialNews.getArticles().get(0).getContent());
            wechatArticleOrigin.setContentSourceUrl(wxMpMaterialNews.getArticles().get(0).getContentSourceUrl());
            wechatArticleOrigin.setCreateTime(wxMpMaterialNews.getCreateTime());
            wechatArticleOrigin.setUpdateTime(wxMpMaterialNews.getUpdateTime());
            wechatArticleOrigin.setDigest(wxMpMaterialNews.getArticles().get(0).getDigest());
            wechatArticleOrigin.setMid(articleUpdate.getMediaId());
            wechatArticleOrigin.setThumbMediaId(wxMpMaterialNews.getArticles().get(0).getThumbMediaId());
            wechatArticleOrigin.setThumbUrl(wxMpMaterialNews.getArticles().get(0).getThumbUrl());
            wechatArticleOrigin.setOnlyFansCanComment(wxMpMaterialNews.getArticles().get(0).getOnlyFansCanComment());
            wechatArticleOrigin.setNeedOpenComment(wxMpMaterialNews.getArticles().get(0).getNeedOpenComment());
            wechatArticleOrigin.setTitle(wxMpMaterialNews.getArticles().get(0).getTitle());
            wechatArticleOrigin.setShowcCoverPic(wxMpMaterialNews.getArticles().get(0).isShowCoverPic());
            wechatArticleOrigin.setUrl(wxMpMaterialNews.getArticles().get(0).getUrl());
            articleOriginMapper.updateByPrimaryKeySelective(wechatArticleOrigin);
        }
    }

    @Override
    public void delete(Integer id) {
        WechatArticle wechatArticle  = articleMapper.selectByPrimaryKey(id);
        WxMpService wxMpService = WxMpConfiguration.getWxMpService(systemConfigService.queryWXOfficialAccountConfig());
        try {
            wxMpService.getMaterialService().materialDelete(wechatArticle.getMediaId());
            articleMapper.deleteByPrimaryKey(id);
            articleOriginMapper.deleteByPrimaryKey(wechatArticle.getMediaId());
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

    }

    @Override
    public CommonResult uploadNews(WechatArticle wechatArticle) throws Exception {

        if (wechatArticle.getMediaId() == null){
            wechatArticle = articleMapper.selectByPrimaryKey(wechatArticle.getId());
        }
        WxMpService wxMpService = WxMpConfiguration.getWxMpService(systemConfigService.queryWXOfficialAccountConfig());
        //推送开始
        WxMpMassTagMessage massMessage = new WxMpMassTagMessage();
        massMessage.setMsgType(WxConsts.MassMsgType.MPNEWS);
        massMessage.setMediaId(wechatArticle.getMediaId());
        massMessage.setSendAll(true);

        WxMpMassSendResult massResult = wxMpService.getMassMessageService()
                .massGroupMessageSend(massMessage);
        if(!massResult.getErrorCode().equals("0")) {
            log.info("error:"+massResult.getErrorMsg());
            CommonResult.failed("发送失败");
        }
        log.info( "massResult : {}", JSONUtil.toJsonStr( massResult ) );
//        log.info( "wxMpMaterialUploadResult : {}", JSONUtil.toJsonStr( wxMpMaterialUploadResult1 ) );
        return CommonResult.success("");
    }
     public WxMpMaterialUploadResult uploadPhotoToWx(WxMpService wxMpService, String picPath) throws WxErrorException {
        WxMpMaterial wxMpMaterial = new WxMpMaterial();

        String filename = String.valueOf( System.currentTimeMillis() ) + ".png";
        String downloadPath = uploadDirStr + filename;
        long size = HttpUtil.downloadFile(picPath, FileUtil.file(downloadPath));
        picPath = downloadPath;
        File picFile = new File( picPath );
        wxMpMaterial.setFile( picFile );
        wxMpMaterial.setName( picFile.getName() );
        log.info( "picFile name : {}", picFile.getName() );
        WxMpMaterialUploadResult wxMpMaterialUploadResult = wxMpService.getMaterialService().materialFileUpload( WxConsts.MediaFileType.IMAGE, wxMpMaterial );
        log.info( "wxMpMaterialUploadResult : {}", JSONUtil.toJsonStr( wxMpMaterialUploadResult ) );
        return wxMpMaterialUploadResult;
    }
    private String processContent(WxMpService wxMpService,String content) throws WxErrorException {
        if(StringUtils.isBlank( content )){
            return content;
        }
        String imgReg = "<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>";
        List<String> imgList = ReUtil.findAllGroup1( imgReg,content);
        for (int j = 0; j < imgList.size(); j++) {
            String imgSrc = imgList.get( j );
            String filepath = URLUtils.getParam( imgSrc,"filepath" );

            if(StringUtils.isBlank( filepath )){//网络图片URL，需下载到本地
                String filename = String.valueOf( System.currentTimeMillis() ) + ".png";
                String downloadPath = uploadDirStr + filename;
                long size = HttpUtil.downloadFile(imgSrc, FileUtil.file(downloadPath));
                filepath = downloadPath;
            }
            WxMediaImgUploadResult wxMediaImgUploadResult = wxMpService.getMaterialService().mediaImgUpload( new File(filepath) );
            content = StringUtils.replace( content,imgList.get( j ),wxMediaImgUploadResult.getUrl());
        }
        return content;
    }


}
