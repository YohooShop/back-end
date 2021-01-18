package com.yoooho.mall.service;

import com.yoooho.mall.common.CommonPage;
import com.yoooho.mall.model.PmsStore;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PmsStoreService {
    public CommonPage queryStoreList(Pageable pageable);
    public List<PmsStore> queryStoreAll();
    public PmsStore queryStoreDetail(Long id);
}
