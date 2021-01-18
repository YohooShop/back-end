package com.yoooho.mall.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.yoooho.mall.common.CommonPage;
import com.yoooho.mall.common.utils.DateUtils;
import com.yoooho.mall.dto.PmsProductCombParam;
import com.yoooho.mall.dto.PmsProductCombQueryParam;
import com.yoooho.mall.dto.PmsProductCombResult;
import com.yoooho.mall.mapper.PmsProductCombinationMapper;
import com.yoooho.mall.model.PmsProductCombination;
import com.yoooho.mall.model.PmsProductCombinationExample;
import com.yoooho.mall.service.PmsProductCombService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class PmsProductCombServiceImpl implements PmsProductCombService {
    @Autowired
    PmsProductCombinationMapper pmsProductCombinationMapper;

    @Override
    public int addSeckillProduct(PmsProductCombParam pmsProductCombParam) {
        //创建商品
        PmsProductCombination product = pmsProductCombParam;

        if(ObjectUtil.isNotNull(product.getStartTimeDate())){
            product.setStartTime(DateUtils.
                    dateToTimestamp(product.getStartTimeDate()));
        }
        if(ObjectUtil.isNotNull(product.getEndTimeDate())){
            product.setEndTime(DateUtils.
                    dateToTimestamp(product.getEndTimeDate()));
        }
        product.setAddTime(String.valueOf(DateUtils.getSecondTimestampTwo()));
        int res = pmsProductCombinationMapper.insertSelective(product);
        return res;
    }

    @Override
    public Map<String, Object> list(PmsProductCombQueryParam queryParam, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        PmsProductCombinationExample example = new PmsProductCombinationExample();
        PmsProductCombinationExample.Criteria criteria= example.createCriteria();
        if (queryParam.getTitle() != null && !queryParam.getTitle().equals("")){
            criteria.andNameEqualTo(queryParam.getTitle());
        }
        criteria.andDeleteStatusEqualTo(false);
        List<PmsProductCombination> list = pmsProductCombinationMapper.selectByExampleWithBLOBs(example);
        CommonPage result = CommonPage.restPage(list);
        list = result.getList();
        List resList = new ArrayList();
        for (PmsProductCombination pmsProductCombination : list){
            String string =  JSONObject.toJSONString(pmsProductCombination);
            PmsProductCombResult productCombResult = JSONObject.parseObject(string, PmsProductCombResult.class);
            productCombResult.setCountPeopleAll(0);
            productCombResult.setCountPeopleBrowse(0);
            productCombResult.setCountPeoplePink(0);
            resList.add(productCombResult);
        }


        Map<String,Object> map = new LinkedHashMap<>(2);
        map.put("content",resList);
        map.put("totalElements",result.getTotal());
        return map;
    }

    @Override
    public List<PmsProductCombination> list(PmsProductCombQueryParam queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProductCombinationExample example = new PmsProductCombinationExample();
        PmsProductCombinationExample.Criteria criteria= example.createCriteria();
        if (queryParam.getKeyword() != null && !queryParam.getKeyword().equals("")){
            criteria.andNameLike(queryParam.getKeyword());
        }
        criteria.andDeleteStatusEqualTo(false);
        List<PmsProductCombination > list = pmsProductCombinationMapper.selectByExampleWithBLOBs(example);
        return list;
    }

    @Override
    public void update(PmsProductCombParam pmsProductSeckillParam) {
        if(ObjectUtil.isNotNull(pmsProductSeckillParam.getStartTimeDate())){
            pmsProductSeckillParam.setStartTime(DateUtils.
                    dateToTimestamp(pmsProductSeckillParam.getStartTimeDate()));
        }
        if(ObjectUtil.isNotNull(pmsProductSeckillParam.getEndTimeDate())){
            pmsProductSeckillParam.setEndTime(DateUtils.
                    dateToTimestamp(pmsProductSeckillParam.getEndTimeDate()));
        }
        pmsProductCombinationMapper.updateByPrimaryKeySelective(pmsProductSeckillParam);
    }

    @Override
    public void updateStatus(Long id, boolean isShow) {
       PmsProductCombination productCombination =  pmsProductCombinationMapper.selectByPrimaryKey(id);
       productCombination.setIsShow(isShow);
       pmsProductCombinationMapper.updateByPrimaryKeyWithBLOBs(productCombination);
    }

    @Override
    public PmsProductCombination getInfo(Long id) {
        return   pmsProductCombinationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delect(Long id) {
        PmsProductCombination productCombination = pmsProductCombinationMapper.selectByPrimaryKey(id);
        productCombination.setDeleteStatus(true);

        return  pmsProductCombinationMapper.updateByPrimaryKeySelective(productCombination);
    }
}
