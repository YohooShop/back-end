package com.yoooho.mall.express.repository;

import com.yoooho.mall.express.dao.ExpressInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface OrderExpressInfoRepository extends MongoRepository<ExpressInfo,String> {
    void deleteByOrderCode(String orderCode);
    List<ExpressInfo> findByOrderCode(String orderCode);
}
