package com.yoooho.mall.service.impl;

import com.yoooho.mall.domain.*;
import com.yoooho.mall.domain.MemberProductCollection;
import com.yoooho.mall.domain.PromotionProduct;
import com.yoooho.mall.model.*;
import com.yoooho.mall.dao.PortalProductDao;
import com.yoooho.mall.repository.MemberProductCollectionRepository;
import com.yoooho.mall.service.UmsMemberService;
import com.yoooho.mall.service.ProductService;
import com.yoooho.mall.model.UmsMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private PortalProductDao portalProductDao;
    @Autowired
    private MemberProductCollectionRepository productCollectionRepository;
    @Autowired
    private UmsMemberService memberService;

    @Override
    public PromotionProduct getProductDetail(Long id) throws Exception {
        PromotionProduct promotionProduct = portalProductDao.getProduct(id);
        UmsMember member = memberService.getCurrentMember();
        if (member != null){
            MemberProductCollection findCollection = productCollectionRepository.findByMemberIdAndProductId(member.getId(), id);
            if (findCollection != null){
                promotionProduct.setCollection(true);
            }
           promotionProduct.setShopCartNumber(memberService.getShopCarNumber(member.getId()));
        }
        return promotionProduct;
    }




}
