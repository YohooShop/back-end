package com.yoooho.mall.service;

import com.yoooho.mall.model.SmsHomeNav;

import java.util.List;

public interface SmsHomeNavService {
    /**
     * 添加
     */
    int create(SmsHomeNav nav);
    /**
     * 批量删除
     */
    int delete(List<Long> ids);


    /**
     * 修改上、下线状态
     */
    int updateStatus(Long id, Integer status);

    /**
     * 获取广告详情
     */
    SmsHomeNav getItem(Long id);

    /**
     * 更新广告
     */
    int update(Long id, SmsHomeNav nav);

    /**
     * 分页查询
     */
    List<SmsHomeNav> list(String name, Integer pageSize, Integer pageNum);


}
