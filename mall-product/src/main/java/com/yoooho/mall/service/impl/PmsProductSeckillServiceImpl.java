package com.yoooho.mall.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.yoooho.mall.common.CommonPage;
import com.yoooho.mall.common.utils.DateUtils;
import com.yoooho.mall.dto.PmsProductKillQueryParam;
import com.yoooho.mall.dto.PmsProductSeckillParam;
import com.yoooho.mall.dto.PmsProductSeckillResult;
import com.yoooho.mall.mapper.PmsProductSeckillMapper;
import com.yoooho.mall.mapper.SmsFlashPromotionSessionMapper;
import com.yoooho.mall.model.PmsProductSeckill;
import com.yoooho.mall.model.PmsProductSeckillExample;
import com.yoooho.mall.model.SmsFlashPromotionSession;
import com.yoooho.mall.rabbitmq.MQSeckillProductChangeSender;
import com.yoooho.mall.service.PmsProductSeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class PmsProductSeckillServiceImpl implements PmsProductSeckillService {

    @Autowired
    PmsProductSeckillMapper pmsProductSeckillMapper;

    @Autowired
    SmsFlashPromotionSessionMapper sessionMapper;

    @Autowired
    MQSeckillProductChangeSender mqSeckillProductChangeSender;
    @Override
    public int addSeckillProduct(PmsProductSeckillParam productSeckillParam) {
        //创建商品
        PmsProductSeckill product = productSeckillParam;

        if(ObjectUtil.isNotNull(product.getStartTimeDate())){
            product.setStartTime(DateUtils.
                    dateToTimestamp(product.getStartTimeDate()));
        }
        if(ObjectUtil.isNotNull(product.getEndTimeDate())){
            product.setStopTime(DateUtils.
                    dateToTimestamp(product.getEndTimeDate()));
        }
        product.setAddTime(String.valueOf(DateUtils.getSecondTimestampTwo()));
        int res = pmsProductSeckillMapper.insertSelective(product);
        if (res == 1) {
            mqSeckillProductChangeSender.sendMessage(product.getId(),0);
        }
        return res;
    }

    @Override
    public Map<String, Object> list(PmsProductKillQueryParam queryParam, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        PmsProductSeckillExample example = new PmsProductSeckillExample();
        PmsProductSeckillExample.Criteria criteria= example.createCriteria();
        if (queryParam.getTitle() != null && !queryParam.getTitle().equals("")){
          criteria.andNameEqualTo(queryParam.getTitle());
        }
        criteria.andDeleteStatusEqualTo(0);
        List<PmsProductSeckill > list = pmsProductSeckillMapper.selectByExampleWithBLOBs(example);
        CommonPage result = CommonPage.restPage(list);
        list = result.getList();
        int nowTime = DateUtils.getSecondTimestampTwo();

        List resList = new ArrayList();
        for (PmsProductSeckill pmsProductSeckill : list){
            SmsFlashPromotionSession session = sessionMapper.selectByPrimaryKey(Long.parseLong(String.valueOf(pmsProductSeckill.getTimeId())));
            String string =  JSONObject.toJSONString(pmsProductSeckill);
            PmsProductSeckillResult pmsProductSeckillResult =  JSONObject.parseObject(string, PmsProductSeckillResult.class);
            if(pmsProductSeckillResult.getStatus() == 1){
                if(pmsProductSeckillResult.getStartTime() > nowTime){
                    pmsProductSeckillResult.setStatusStr("活动未开始");
                }else if(pmsProductSeckillResult.getStopTime() < nowTime){
                    pmsProductSeckillResult.setStatusStr("活动已结束");
                }else if(pmsProductSeckillResult.getStopTime() > nowTime && pmsProductSeckillResult.getStartTime() < nowTime){
                    pmsProductSeckillResult.setStatusStr("正在进行中");
                }
            }else {
                pmsProductSeckillResult.setStatusStr("关闭");
            }

            if (session != null){
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
                String startTime =  dateFormat.format(session.getStartTime());
                String endTime = dateFormat.format(session.getEndTime());
                pmsProductSeckillResult.setTimeSlot(startTime+"-"+endTime);
            }

            resList.add(pmsProductSeckillResult);
        }

        Map<String,Object> map = new LinkedHashMap<>(2);
        map.put("content",resList);
        map.put("totalElements",result.getTotal());
        return map;
    }

    @Override
    public List<PmsProductSeckill> list(PmsProductKillQueryParam queryParam, Integer pageSize, Integer pageNum){

        PageHelper.startPage(pageNum, pageSize);
        PmsProductSeckillExample example = new PmsProductSeckillExample();
        PmsProductSeckillExample.Criteria criteria= example.createCriteria();
        if (queryParam.getKeyword() != null && !queryParam.getKeyword().equals("")){
            criteria.andNameLike(queryParam.getKeyword());
        }
        criteria.andDeleteStatusEqualTo(0);
        List<PmsProductSeckill > list = pmsProductSeckillMapper.selectByExampleWithBLOBs(example);
        return list;
    }

    @Override
    public void update(PmsProductSeckillParam pmsProductSeckillParam) {
        if(ObjectUtil.isNotNull(pmsProductSeckillParam.getStartTimeDate())){
            pmsProductSeckillParam.setStartTime(DateUtils.
                    dateToTimestamp(pmsProductSeckillParam.getStartTimeDate()));
        }
        if(ObjectUtil.isNotNull(pmsProductSeckillParam.getEndTimeDate())){
            pmsProductSeckillParam.setStopTime(DateUtils.
                    dateToTimestamp(pmsProductSeckillParam.getEndTimeDate()));
        }
        pmsProductSeckillMapper.updateByPrimaryKeySelective(pmsProductSeckillParam);
        mqSeckillProductChangeSender.sendMessage(pmsProductSeckillParam.getId(),0);
    }

    @Override
    public PmsProductSeckill getInfo(Long id) {
       return   pmsProductSeckillMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delect(Long id) {
        PmsProductSeckill productSeckill = pmsProductSeckillMapper.selectByPrimaryKey(id);
        productSeckill.setDeleteStatus(1);
        return  pmsProductSeckillMapper.updateByPrimaryKeySelective(productSeckill);
    }
}
