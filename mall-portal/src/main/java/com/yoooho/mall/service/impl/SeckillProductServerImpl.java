package com.yoooho.mall.service.impl;

import com.yoooho.mall.dao.PortalProductDao;
import com.yoooho.mall.domain.HomeFlashPromotion;
import com.yoooho.mall.domain.MemberProductCollection;
import com.yoooho.mall.domain.PromotionKillProduct;
import com.yoooho.mall.mapper.PmsProductSeckillMapper;
import com.yoooho.mall.mapper.SmsFlashPromotionSessionMapper;
import com.yoooho.mall.model.*;
import com.yoooho.mall.repository.MemberProductCollectionRepository;
import com.yoooho.mall.service.HomeService;
import com.yoooho.mall.service.SeckillProductServer;
import com.yoooho.mall.service.UmsMemberService;
import com.yoooho.mall.util.DateUtil;
import com.yoooho.mall.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SeckillProductServerImpl implements SeckillProductServer {
    @Autowired
    private UmsMemberService memberService;
    @Autowired
    private PortalProductDao portalProductDao;
    @Autowired
    private SmsFlashPromotionSessionMapper flashPromotionSessionMapper;
    @Autowired
    private HomeService homeService;

    @Autowired
    private PmsProductSeckillMapper seckillMapper;

    @Autowired
    private MemberProductCollectionRepository productCollectionRepository;
    @Override
    public PromotionKillProduct getKillProductDetail(Long id) throws Exception {
        PromotionKillProduct killProduct = portalProductDao.selectKillProduct(id);
        UmsMember member = memberService.getCurrentMember();
        if (member != null){
            MemberProductCollection findCollection = productCollectionRepository.findByMemberIdAndProductId(member.getId(), id);
            if (findCollection != null){
                killProduct.setCollection(true);
            }
            killProduct.setShopCartNumber(memberService.getShopCarNumber(member.getId()));
        }
        Date date =  new Date();
        if (DateUtil.getTime(date).compareTo(killProduct.getFlashInfo().getStartTime()) >= 0 && DateUtil.getTime(date).compareTo(killProduct.getFlashInfo().getEndTime())<0){
            Date currTime = date;
            if ( currTime.compareTo(killProduct.getStartTimeDate()) >=0 &&  currTime.compareTo(killProduct.getEndTimeDate()) <0){

                if (killProduct.getStock() - killProduct.getLockStock() <= 0){
                    killProduct.setKillStatus(3);
                }else {
                    killProduct.setKillStatus(1);
                }

            }else {
                if (currTime.compareTo(killProduct.getStartTimeDate())<0){
                    killProduct.setKillStatus(0);
                }

                if (currTime.compareTo(killProduct.getEndTimeDate()) >=0){
                    killProduct.setKillStatus(2);
                }
            }
        }else {
            if (DateUtil.getTime(date).compareTo(killProduct.getFlashInfo().getStartTime()) < 0){
                killProduct.setKillStatus(0);
            }
            if (DateUtil.getTime(date).compareTo(killProduct.getFlashInfo().getEndTime()) > 0){
                killProduct.setKillStatus(2);
            }
        }
        return killProduct;
    }

    @Override
    public PmsProductSeckill getKillProduct(Long id) throws Exception {

        return seckillMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PmsProductSeckill> listKillGoods() {
        PmsProductSeckillExample example = new PmsProductSeckillExample();
        return   seckillMapper.selectByExample(example);
    }



    @Override
    public boolean killProductIsKilling (Long id, Long userId) throws Exception {
        PromotionKillProduct killProduct = portalProductDao.selectKillProduct(id);
        if (killProduct == null) {
            return true;
        }

        if (userId != null){
            MemberProductCollection findCollection = productCollectionRepository.findByMemberIdAndProductId(userId, id);
            if (findCollection != null){
                killProduct.setCollection(true);
            }
            killProduct.setShopCartNumber(memberService.getShopCarNumber(userId));
        }
        Date date =  new Date();
        if (DateUtil.getTime(date).compareTo(killProduct.getFlashInfo().getStartTime()) >= 0 && DateUtil.getTime(date).compareTo(killProduct.getFlashInfo().getEndTime())<0){
            Date currTime = date;
            if ( currTime.compareTo(killProduct.getStartTimeDate()) >=0 &&  currTime.compareTo(killProduct.getEndTimeDate()) <0){
                if (killProduct.getStock() - killProduct.getLockStock()<= 0){
                    return false;
                }else {
                    return true;
                }
            }else {
                if (currTime.compareTo(killProduct.getStartTimeDate())<0){
                    return false;
                }
                if (currTime.compareTo(killProduct.getEndTimeDate()) >=0){
                    return false;
                }
            }
        }else {
            if (DateUtil.getTime(date).compareTo(killProduct.getFlashInfo().getStartTime()) < 0){
                return false;
            }
            if (DateUtil.getTime(date).compareTo(killProduct.getFlashInfo().getEndTime()) > 0){
                return false;
            }
        }
        return false;
    }

    @Override
    public List getKillSence() {
        SmsFlashPromotionSessionExample example = new SmsFlashPromotionSessionExample();
        example.createCriteria().andStatusEqualTo(1);
        return flashPromotionSessionMapper.selectByExample(example);
    }

    @Override
    public HomeFlashPromotion killSenceDetailContent(Long id) {
        SmsFlashPromotionSession flashPromotionSession = flashPromotionSessionMapper.selectByPrimaryKey(id);
        HomeFlashPromotion homeFlashPromotion = new HomeFlashPromotion();
        Date now = new Date();
        List<PmsProductSeckill> productSeckills =   homeService.getProductSeckill(id,now);
        homeFlashPromotion.setStartTime(flashPromotionSession.getStartTime());
        homeFlashPromotion.setEndTime(flashPromotionSession.getEndTime());
        homeFlashPromotion.setProductList(productSeckills);
        return homeFlashPromotion;
    }
}
