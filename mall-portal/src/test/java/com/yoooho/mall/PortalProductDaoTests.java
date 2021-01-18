package com.yoooho.mall;

import com.yoooho.mall.domain.PromotionProduct;
import com.yoooho.mall.dao.PortalProductDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yoooho on 2019/8/27.
 * 前台商品查询逻辑单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalProductDaoTests {
    @Autowired
    private PortalProductDao portalProductDao;
    @Test
    public void testGetPromotionProductList(){
        List<Long> ids = new ArrayList<>();
        ids.add(26L);
        ids.add(27L);
        ids.add(28L);
        ids.add(29L);
        List<PromotionProduct> promotionProductList = portalProductDao.getPromotionProductList(ids);
        Assert.assertEquals(4,promotionProductList.size());
    }
}
