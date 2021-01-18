package com.yoooho.mall.service;

import com.yoooho.mall.common.CommonPage;
import com.yoooho.mall.dto.PmsStoreQueryParam;
import com.yoooho.mall.model.PmsStore;
import com.yoooho.mall.model.PmsStoreConfig;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface PmsStoreService {
    public int addStoreConfig (PmsStoreConfig storeConfig);
    public  int updateStoreConfig (PmsStoreConfig storeConfig);
    public List<PmsStoreConfig> queryStoreConfigAll();
    public CommonPage queryStoreList(PmsStoreQueryParam queryParam, Pageable pageable);
    public List<PmsStore> queryStoreAll(PmsStoreQueryParam queryParam);

    public int  addStore(PmsStore store);
    public int updateStore(PmsStore store);

    public void delStores(Long[] ids);

    public void download(List<PmsStore> stores, HttpServletResponse response);
}
