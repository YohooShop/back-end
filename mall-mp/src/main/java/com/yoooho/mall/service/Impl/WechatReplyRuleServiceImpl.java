package com.yoooho.mall.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.yoooho.mall.common.annotation.QueryHelp;
import com.yoooho.mall.common.exception.EntityExistException;
import com.yoooho.mall.common.utils.PageUtil;
import com.yoooho.mall.common.utils.ValidationUtil;
import com.yoooho.mall.config.WxMpConfiguration;
import com.yoooho.mall.domian.WechatReply;
import com.yoooho.mall.dto.WechatReplyDTO;
import com.yoooho.mall.dto.WechatReplyParams;
import com.yoooho.mall.dto.WechatReplyQueryCriteria;
import com.yoooho.mall.mapper.WechatReplyContentMapper;
import com.yoooho.mall.model.WechatReplyContent;
import com.yoooho.mall.model.WechatReplyContentExample;
import com.yoooho.mall.model.WechatReplyExample;
import com.yoooho.mall.model.WxOfficialAccountConfig;
import com.yoooho.mall.repository.WechatReplyRepository;
import com.yoooho.mall.service.SystemConfigService;
import com.yoooho.mall.service.WechatReplyRuleService;
import com.yoooho.mall.service.mapper.WechatReplyMapper;
import com.yoooho.mall.utils.FileTools;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.material.WxMpMaterial;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialUploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class WechatReplyRuleServiceImpl implements WechatReplyRuleService {

    private final WechatReplyRepository wechatReplyRepository;

    private final WechatReplyMapper wechatReplyMapper;

    @Autowired
    com.yoooho.mall.mapper.WechatReplyMapper replyMapper;

    @Autowired
    WechatReplyContentMapper wechatReplyContentMapper;

    @Autowired

    SystemConfigService systemConfigService;

    public WechatReplyRuleServiceImpl(WechatReplyRepository wechatReplyRepository, WechatReplyMapper wechatReplyMapper) {
        this.wechatReplyRepository = wechatReplyRepository;
        this.wechatReplyMapper = wechatReplyMapper;
    }

    @Override
    public Map<String, Object> queryAll(WechatReplyQueryCriteria criteria, Pageable pageable){
        Page<WechatReply> page = wechatReplyRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(wechatReplyMapper::toDto));
    }

    @Override
    public List<WechatReplyDTO> queryAll(WechatReplyQueryCriteria criteria){
        return wechatReplyMapper.toDto(wechatReplyRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public Object findById(Integer id) {
        Optional<WechatReply> yxWechatReply = wechatReplyRepository.findById(Long.valueOf(id));
        ValidationUtil.isNull(yxWechatReply,"WechatReply","id",id);
        WechatReplyDTO wechatReplyDTO = wechatReplyMapper.toDto(yxWechatReply.get());
        WechatReplyContentExample example = new WechatReplyContentExample();
        example.createCriteria().andWechatReplyIdEqualTo(wechatReplyDTO.getId());
        List<WechatReplyContent> wechatReplyContents = wechatReplyContentMapper.selectByExampleWithBLOBs(example);
        Map map = new HashMap();

        map.put("data",wechatReplyDTO);
        if (wechatReplyContents.size()>0){
            map.put("contentJson",wechatReplyContents.get(0).getContent());
        }
        return map;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public WechatReplyDTO create(WechatReplyParams resources) {
        if(wechatReplyRepository.findByMatchValue(resources.getMatchValue()) != null){
            throw new EntityExistException(WechatReply.class,"key",resources.getMatchValue());
        }

        if (resources.getReplyType().equals("video")){
            resources = handelVoideWechatReplyParams(resources);
        }
        if (resources.getReplyType().equals("image")){
            resources = handelImageWechatReplyParams(resources);
        }
        WechatReply reply = new WechatReply();
        reply.copy(resources);
        WechatReplyDTO wechatReplyDTO =  wechatReplyMapper.toDto(wechatReplyRepository.save(reply));

        if (resources.getReplyType().equals("news")) {
            com.yoooho.mall.model.WechatReply wechatReply = new com.yoooho.mall.model.WechatReply();
            wechatReply.setId(wechatReplyDTO.getId());
            wechatReply.setReplyContent(String.valueOf(wechatReplyDTO.getId()));
            replyMapper.updateByPrimaryKeySelective(wechatReply);

        }
        WechatReplyContent wechatReplyContent = new WechatReplyContent();
        wechatReplyContent.setContent(resources.getContentStr());
        wechatReplyContent.setWechatReplyId(wechatReplyDTO.getId());
        wechatReplyContentMapper.insertSelective(wechatReplyContent);
        return wechatReplyDTO;
    }
    WechatReplyParams  handelVoideWechatReplyParams(WechatReplyParams resources){
        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        WxMpService wxService = WxMpConfiguration.getWxMpService(config);
        Map map = (Map) JSONObject.parse(resources.getContentStr());
        File file = FileTools.urlToFile((String) map.get("link"));
        try {
            WxMpMaterialUploadResult wxMpMaterialUploadResult = uploadFileViode(wxService,file, (String)map.get("title"), (String)map.get("desc"));
            resources.setReplyContent(wxMpMaterialUploadResult.getMediaId());
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        file.delete();
        return resources;
   }
    WechatReplyParams  handelImageWechatReplyParams(WechatReplyParams resources){
        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        WxMpService wxService = WxMpConfiguration.getWxMpService(config);
        File file = FileTools.urlToFile(resources.getReplyContent());
        try {
            WxMpMaterialUploadResult wxMpMaterialUploadResult = uploadFileImage(wxService,file);
            resources.setReplyContent(wxMpMaterialUploadResult.getMediaId());
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        file.delete();
        return resources;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(WechatReplyParams resources) {

        if (resources.getReplyType().equals("video")){
            resources = handelVoideWechatReplyParams(resources);
        }
        if (resources.getReplyType().equals("image")){
            resources = handelImageWechatReplyParams(resources);
        }
        Optional<WechatReply> optionalYxWechatReply = wechatReplyRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalYxWechatReply,"WechatReply","id",resources.getId());
        WechatReply wechatReply = optionalYxWechatReply.get();
        WechatReply wechatReply1 = null;
        wechatReply1 = wechatReplyRepository.findByMatchValue(resources.getMatchValue());
        if(wechatReply1 != null && !wechatReply1.getId().equals(wechatReply.getId())){
            throw new EntityExistException(WechatReply.class,"key",resources.getMatchValue());
        }
        wechatReply.copy(resources);
        if (resources.getReplyType().equals("news")) {
            wechatReply.setReplyContent(String.valueOf(wechatReply.getId()));
        }
        WechatReplyContent wechatReplyContent = new WechatReplyContent();
        wechatReplyContent.setContent(resources.getContentStr());
        WechatReplyContentExample example = new WechatReplyContentExample();
        example.createCriteria().andWechatReplyIdEqualTo(resources.getId());
        int res = wechatReplyContentMapper.updateByExampleSelective(wechatReplyContent,example);
        wechatReplyRepository.save(wechatReply);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        WechatReplyContentExample example = new WechatReplyContentExample();
        example.createCriteria().andWechatReplyIdEqualTo(Long.valueOf(id));
        wechatReplyContentMapper.deleteByExample(example);
        wechatReplyRepository.deleteById(Long.valueOf(id));
    }


    @Override
    public WechatReply isExist(String key) {
        WechatReply wechatReply = wechatReplyRepository.findByMatchValue(key);
        return wechatReply;
    }

    /**
     * 筛选符合条件的回复规则
     *
     * @param exactMatch 是否精确匹配
     * @param keywords   关键词
     * @return 规则列表
     */
    @Override
    public List getMatchedRules(boolean exactMatch, String keywords) {
        LocalTime now = LocalTime.now();
        return this.getValidRules().stream()
                .filter(rule->null == rule.getEffectTimeStart() || dateToLocalTime(rule.getEffectTimeStart()).isBefore(now))// 检测是否在有效时段，effectTimeStart为null则一直有效
                .filter(rule->null == rule.getEffectTimeEnd() || dateToLocalTime(rule.getEffectTimeEnd()).isAfter(now)) // 检测是否在有效时段，effectTimeEnd为null则一直有效
                .filter(rule->isMatch(exactMatch || rule.getExactMatch() == 1,rule.getMatchValue().split(","),keywords)) //检测是否符合匹配规则
                .collect(Collectors.toList());
    }

    @Override
    public void delect(List<Long> ids) throws Exception {
        for (int i = 0; i < ids.size(); i++) {
            replyMapper.deleteByPrimaryKey(ids.get(i));
            WechatReplyContentExample example = new WechatReplyContentExample();
            example.createCriteria().andWechatReplyIdEqualTo(ids.get(i));
            wechatReplyContentMapper.deleteByExample(example);
        }
    }


    /**
     * 获取当前时段内所有有效的回复规则
     *
     * @return
     */
    @Override
    public List<com.yoooho.mall.model.WechatReply> getValidRules() {

        WechatReplyExample example = new WechatReplyExample();
        WechatReplyExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(1);
        criteria.andMatchValueNotEqualTo("");
        criteria.andMatchValueIsNotNull();
        example.setOrderByClause("priority desc");

        return replyMapper.selectByExample(example);

    }

    /**
     * 检测文字是否匹配规则
     * 精确匹配时，需关键词与规则词语一致
     * 非精确匹配时，检测文字需包含任意一个规则词语
     *
     * @param exactMatch 是否精确匹配
     * @param ruleWords  规则列表
     * @param checkWords 需检测的文字
     * @return
     */
    public static boolean isMatch(boolean exactMatch, String[] ruleWords, String checkWords) {
        if (StringUtils.isEmpty(checkWords)) return false;
        for (String words : ruleWords) {
            if (exactMatch && words.equals(checkWords)) return true;//精确匹配，需关键词与规则词语一致
            if (!exactMatch && checkWords.contains(words)) return true;//模糊匹配
        }
        return false;
    }

    public LocalTime dateToLocalTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalTime localTime = localDateTime.toLocalTime();
        return localTime;
    }

    public WxMpMaterialUploadResult uploadFileViode(WxMpService wxMpService, File file, String videoTitle , String videoDesc) throws WxErrorException {
        WxMpMaterial wxMpMaterial = new WxMpMaterial();
        wxMpMaterial.setVideoIntroduction( videoDesc);
        wxMpMaterial.setVideoTitle( videoTitle );
        wxMpMaterial.setFile(file);
        wxMpMaterial.setName(file.getName());

        WxMpMaterialUploadResult wxMpMaterialUploadResult = wxMpService.getMaterialService().materialFileUpload( WxConsts.MediaFileType.VIDEO, wxMpMaterial );
        return wxMpMaterialUploadResult;
    }

    public WxMpMaterialUploadResult uploadFileImage(WxMpService wxMpService, File file) throws WxErrorException {
        WxMpMaterial wxMpMaterial = new WxMpMaterial();
        wxMpMaterial.setFile( file );
        wxMpMaterial.setName( file.getName() );
        WxMpMaterialUploadResult wxMpMaterialUploadResult = wxMpService.getMaterialService().materialFileUpload( WxConsts.MediaFileType.IMAGE, wxMpMaterial );
        return wxMpMaterialUploadResult;
    }

}
