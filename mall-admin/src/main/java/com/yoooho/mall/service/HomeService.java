package com.yoooho.mall.service;

import com.yoooho.mall.common.CommonResult;

public interface HomeService {
    public CommonResult homeData();
    public CommonResult statisticsData(Long beginDate,Long endDate);

}
