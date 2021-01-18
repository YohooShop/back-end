package com.yoooho.mall.service.Impl;

import com.github.pagehelper.PageHelper;
import com.yoooho.mall.mapper.WechatMsgMapper;
import com.yoooho.mall.model.WechatMsg;
import com.yoooho.mall.model.WechatMsgExample;
import com.yoooho.mall.service.WechatMsgSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class WechatMsgSeviceImpl implements WechatMsgSevice {

    @Autowired
    WechatMsgMapper msgMapper;
    @Override
    public List<WechatMsg>  queryPage(Map<String, Object> params) {
        int pageNum = Integer.parseInt((String) params.get("page")) ;
        int pageSize = Integer.parseInt((String) params.get("limit"));
        String startTime = (String)params.get("startTime");
        String openid = (String)params.get("openid");
        String msgTypes = (String)params.get("msgTypes");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        PageHelper.startPage(pageNum, pageSize);
        WechatMsgExample example = new WechatMsgExample();
        example.setOrderByClause("create_time desc");
        WechatMsgExample.Criteria criteria =example.createCriteria();
        criteria.andCreateTimeGreaterThanOrEqualTo(date);
        if (openid!=null && !openid.equals("")){
            criteria.andOpenidEqualTo(openid);
        }
        List<WechatMsg> wechatMsgs = msgMapper.selectByExampleWithBLOBs(example);
        return wechatMsgs;
    }

    @Override
    public void addWxMsg(WechatMsg log) {
        msgMapper.insert(log);
    }

    @Override
    public WechatMsg getById(long id) {
        return msgMapper.selectByPrimaryKey(id);
    }

    @Override
    public void removeByIds(List<Long> ids) {
        for (int i = 0; i < ids.size(); i++) {
            long id = ids.get(i);
            msgMapper.deleteByPrimaryKey(id);
        }
    }
}
