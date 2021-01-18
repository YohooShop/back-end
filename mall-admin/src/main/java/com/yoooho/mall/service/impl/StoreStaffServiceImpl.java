package com.yoooho.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.yoooho.mall.common.CommonPage;
import com.yoooho.mall.common.utils.FileUtil;
import com.yoooho.mall.dto.StoreStaffQueryParam;
import com.yoooho.mall.mapper.PmsStoreStaffMapper;
import com.yoooho.mall.model.PmsStoreStaff;
import com.yoooho.mall.model.PmsStoreStaffExample;
import com.yoooho.mall.service.StoreStaffService;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class StoreStaffServiceImpl implements StoreStaffService {

    @Autowired
    PmsStoreStaffMapper storeStaffMapper;

    @Override
    public Map<String, Object> queryAll(StoreStaffQueryParam criteria, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<PmsStoreStaff> storeStaffs =  queryAll(criteria);
        CommonPage result = CommonPage.restPage(storeStaffs);
        Map<String,Object> map = new LinkedHashMap<>(2);
        map.put("content",result.getList());
        map.put("totalElements",result.getTotal());
        return map;
    }

    @Override
    public List<PmsStoreStaff> queryAll(StoreStaffQueryParam criteria) {
        PmsStoreStaffExample storeStaffExample = new PmsStoreStaffExample();
        PmsStoreStaffExample.Criteria  criteria1 = storeStaffExample.createCriteria();
        criteria.getNickname();
        if (StringUtil.isNotBlank(criteria.getNickname())) {
            criteria1.andNicknameLike(criteria.getNickname());
        }
        if (StringUtil.isNotBlank(criteria.getStaffName())) {
            criteria1.andStaffNameLike(criteria.getStaffName());
        }
        List<PmsStoreStaff> storeStaffs = storeStaffMapper.selectByExample(new PmsStoreStaffExample());
        return storeStaffs;
    }

    @Override
    public PmsStoreStaff findById(Long id) {
        return storeStaffMapper.selectByPrimaryKey(id);
    }

    @Override
    public PmsStoreStaff create(PmsStoreStaff resources) {
        resources.setAddTime(new Date());
        storeStaffMapper.insertSelective(resources);
        return resources;
    }

    @Override
    public void update(PmsStoreStaff resources) {
        storeStaffMapper.updateByPrimaryKeySelective(resources);
    }

    @Override
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            storeStaffMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void download(List<PmsStoreStaff> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        for (PmsStoreStaff storeStaff : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("微信用户id",storeStaff.getUid());
            map.put("店员头像", storeStaff.getAvatar());
            map.put("门店id", storeStaff.getStoreId());
            map.put("店员名称", storeStaff.getStaffName());
            map.put("手机号码", storeStaff.getPhone());
            map.put("核销开关", storeStaff.getVerifyStatus());
            map.put("状态", storeStaff.getStatus());
            map.put("添加时间", sdf.format(storeStaff.getAddTime()));
            map.put("微信昵称", storeStaff.getNickname());
            map.put("所属门店",storeStaff.getStoreName());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}
