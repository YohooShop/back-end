package com.yoooho.mall.service.impl;

import com.yoooho.mall.dao.PortalPinkProductDao;
import com.yoooho.mall.dao.PortalProductDao;
import com.yoooho.mall.domain.OmsPinkDetail;
import com.yoooho.mall.domain.PromotionPinkProduct;
import com.yoooho.mall.mapper.OmsPinkBuyerMapper;
import com.yoooho.mall.mapper.OmsPinkMapper;
import com.yoooho.mall.mapper.PmsProductCombinationMapper;
import com.yoooho.mall.model.*;
import com.yoooho.mall.service.PinkProductService;
import com.yoooho.mall.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PinkProductServiceImpl implements PinkProductService {

    @Autowired
    private PortalProductDao portalProductDao;

    @Autowired
    private PortalPinkProductDao portalPinkProductDao;

    @Autowired
    private PmsProductCombinationMapper productCombinationMapper;

    @Autowired
    private OmsPinkBuyerMapper pinkBuyerMapper;

    @Autowired
    private OmsPinkMapper pinkMapper;
    @Override
    public PromotionPinkProduct getPinkProductDetail(Long id) throws Exception {
        //设置浏览次数
        PmsProductCombination productCombination = productCombinationMapper.selectByPrimaryKey(id);
        productCombination.setBrowse(productCombination.getBrowse() + 1);
        productCombination.setId(id);
        productCombinationMapper.updateByPrimaryKeyWithBLOBs(productCombination);
        //团购商品信息
        PromotionPinkProduct promotionPinkProduct = portalProductDao.selectPinkProduct(id);
        pinkStatus(promotionPinkProduct);
        //开团信息
        List<OmsPinkDetail> pinkDetails = portalPinkProductDao.selectPinkingDetailByPinkId(id);

        //计算还差几人
        for (int i = 0; i < pinkDetails.size(); i++) {
            OmsPinkDetail pinkDetail = pinkDetails.get(i);
            OmsPinkBuyerExample example = new OmsPinkBuyerExample();
            example.createCriteria().andPinkIdEqualTo(pinkDetail.getId()).andPinkStatusEqualTo(true);
            List list = pinkBuyerMapper.selectByExample(example);
           int num = pinkDetail.getPeople() - Integer.valueOf(list.size());
           pinkDetail.setShortPeople(num);
        }
        //服务器时间

        promotionPinkProduct.setPinkInfos(pinkDetails);
        return promotionPinkProduct;
    }

    @Override
    public List<PmsProductCombination> listPinkGoods() {
        PmsProductCombinationExample example = new PmsProductCombinationExample();
        return productCombinationMapper.selectByExample(example);
    }

    @Override
    public Object getPinkProductInfo(Long pinkId) {
        OmsPinkBuyerExample example = new OmsPinkBuyerExample();
        example.createCriteria().andPinkIdEqualTo(pinkId).andPinkStatusEqualTo(true);
        List<OmsPinkBuyer> buyers = pinkBuyerMapper.selectByExample(example);
        OmsPink pink = pinkMapper.selectByPrimaryKey(pinkId);
        PmsProductCombination productCombination = productCombinationMapper.selectByPrimaryKey(pink.getCid());
        Map map = new HashMap();
        map.put("buyers",buyers);
        map.put("pinkInfo",pink);
        map.put("goodsInfo",productCombination);
        return map;
    }

    public  void pinkStatus(PromotionPinkProduct promotionPinkProduct){
        Date date =  new Date();
        Date currTime = date;
        if (currTime.compareTo(promotionPinkProduct.getStartTimeDate()) >= 0 && currTime.compareTo(promotionPinkProduct.getEndTimeDate()) < 0) {
            if (promotionPinkProduct.getStock() - promotionPinkProduct.getLockStock() <= 0) {
                promotionPinkProduct.setPinkStatus(3);
            } else {
                promotionPinkProduct.setPinkStatus(1);
            }
        } else {
            if (currTime.compareTo(promotionPinkProduct.getStartTimeDate()) < 0) {
                promotionPinkProduct.setPinkStatus(0);
            }

            if (currTime.compareTo(promotionPinkProduct.getEndTimeDate()) >= 0) {
                promotionPinkProduct.setPinkStatus(2);
            }
        }
    }

}
