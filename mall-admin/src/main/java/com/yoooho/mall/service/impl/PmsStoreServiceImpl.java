package com.yoooho.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.yoooho.mall.common.CommonPage;
import com.yoooho.mall.common.utils.FileUtil;
import com.yoooho.mall.dto.PmsStoreQueryParam;
import com.yoooho.mall.mapper.PmsStoreConfigMapper;
import com.yoooho.mall.mapper.PmsStoreMapper;
import com.yoooho.mall.model.PmsStore;
import com.yoooho.mall.model.PmsStoreConfig;
import com.yoooho.mall.model.PmsStoreConfigExample;
import com.yoooho.mall.model.PmsStoreExample;
import com.yoooho.mall.service.PmsStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PmsStoreServiceImpl implements PmsStoreService {

    @Autowired
    PmsStoreConfigMapper storeConfigMapper;
    @Autowired
    PmsStoreMapper pmsStoreMapper;
    public int addStoreConfig (PmsStoreConfig storeConfig) {
        return storeConfigMapper.insertSelective(storeConfig);
    }

    public  int updateStoreConfig(PmsStoreConfig storeConfig) {
        return storeConfigMapper.updateByPrimaryKeySelective(storeConfig);
    }

    public List <PmsStoreConfig> queryStoreConfigAll(){
        PmsStoreConfigExample storeConfigExample = new PmsStoreConfigExample();
        return storeConfigMapper.selectByExample(storeConfigExample);
    }

    @Override
    public CommonPage  queryStoreList(PmsStoreQueryParam queryParam, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<PmsStore> stores = pmsStoreMapper.selectByExample(new PmsStoreExample());
        CommonPage result = CommonPage.restPage(stores);
        return result;
    }

    @Override
    public List<PmsStore> queryStoreAll(PmsStoreQueryParam queryParam) {
        return pmsStoreMapper.selectByExample(new PmsStoreExample());
    }

    @Override
    public int addStore(PmsStore store) {
        store.setAddTime(new Date());
        return  pmsStoreMapper.insertSelective(store);
    }

    @Override
    public int updateStore(PmsStore store) {
        return pmsStoreMapper.updateByPrimaryKeySelective(store);
    }

    @Override
    public void delStores(Long[] ids) {
        for (Long id : ids) {
            pmsStoreMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void download(List<PmsStore> stores, HttpServletResponse response) {
        List<Map<String, Object>> list = new ArrayList<>();
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        for (PmsStore store : stores) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("门店名称", store.getName());
            map.put("简介", store.getIntroduction());
            map.put("手机号码", store.getPhone());
            map.put("省市区", store.getAddress());
            map.put("详细地址", store.getDetailedAddress());
            map.put("门店logo", store.getImage());
            map.put("纬度", store.getLatitude());
            map.put("经度", store.getLongitude());
            map.put("核销有效日期", store.getValidTime());
            map.put("每日营业开关时间", store.getDayTime());
            map.put("添加时间", sdf.format(store.getAddTime()));
            map.put("是否显示", store.getIsShow());
            map.put("是否删除", store.getIsDel());
            list.add(map);
        }
        try {
            FileUtil.downloadExcel(list, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
