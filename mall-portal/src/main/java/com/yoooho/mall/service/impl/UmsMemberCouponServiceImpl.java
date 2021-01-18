package com.yoooho.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.domain.SmsCouponHistoryDetail;
import com.yoooho.mall.mapper.SmsCouponHistoryMapper;
import com.yoooho.mall.mapper.SmsCouponMapper;
import com.yoooho.mall.model.*;
import com.yoooho.mall.dao.CouponDao;
import com.yoooho.mall.dao.SmsCouponHistoryDao;
import com.yoooho.mall.domain.CartPromotionItem;

import com.yoooho.mall.service.UmsMemberCouponService;
import com.yoooho.mall.service.UmsMemberService;
import com.yoooho.mall.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * 会员优惠券管理Service实现类
 * Created by yoooho on 2019/8/29.
 */
@Service
public class UmsMemberCouponServiceImpl implements UmsMemberCouponService {
    @Autowired
    private UmsMemberService memberService;
    @Autowired
    private SmsCouponMapper couponMapper;
    @Autowired
    private SmsCouponHistoryMapper couponHistoryMapper;
    @Autowired
    private SmsCouponHistoryDao couponHistoryDao;
    @Autowired
    private CouponDao couponDao;
    @Override
    public CommonResult add(Long couponId) {
        UmsMember currentMember = memberService.getCurrentMember();
        if (currentMember == null) {
            return CommonResult.failed("用户失效");
        }
        //获取优惠券信息，判断数量
        SmsCoupon coupon = couponMapper.selectByPrimaryKey(couponId);
        if(coupon==null){
            return CommonResult.failed("优惠券不存在");
        }
        if(coupon.getCount()<=0){
            return CommonResult.failed("优惠券已经领完了");
        }
        Date now = new Date();
        System.out.println(coupon.getEnableTime());
        if(now.before(coupon.getEnableTime())){
            return CommonResult.failed("优惠券还没到领取时间");
        }
        //判断用户领取的优惠券数量是否超过限制
        SmsCouponHistoryExample couponHistoryExample = new SmsCouponHistoryExample();
        couponHistoryExample.createCriteria().andCouponIdEqualTo(couponId).andMemberIdEqualTo(currentMember.getId());
        long count = couponHistoryMapper.countByExample(couponHistoryExample);
        if(count>=coupon.getPerLimit()){
            return CommonResult.failed("您已经领取过该优惠券");
        }
        //生成领取优惠券历史
        SmsCouponHistory couponHistory = new SmsCouponHistory();
        couponHistory.setCouponId(couponId);
        couponHistory.setCouponCode(generateCouponCode(currentMember.getId()));
        couponHistory.setCreateTime(now);
        couponHistory.setMemberId(currentMember.getId());
        couponHistory.setMemberNickname(currentMember.getNickname());
        //主动领取
        couponHistory.setGetType(1);
        //未使用
        couponHistory.setUseStatus(0);
        couponHistoryMapper.insert(couponHistory);
        //修改优惠券表的数量、领取数量
        coupon.setCount(coupon.getCount()-1);
        coupon.setReceiveCount(coupon.getReceiveCount()==null?1:coupon.getReceiveCount()+1);
        couponMapper.updateByPrimaryKey(coupon);
        return CommonResult.success(null,"领取成功");
    }

    /**
     * 16位优惠码生成：时间戳后8位+4位随机数+用户id后4位
     */
    private String generateCouponCode(Long memberId) {
        StringBuilder sb = new StringBuilder();
        Long currentTimeMillis = System.currentTimeMillis();
        String timeMillisStr = currentTimeMillis.toString();
        sb.append(timeMillisStr.substring(timeMillisStr.length() - 8));
        for (int i = 0; i < 4; i++) {
            sb.append(new Random().nextInt(10));
        }
        String memberIdStr = memberId.toString();
        if (memberIdStr.length() <= 4) {
            sb.append(String.format("%04d", memberId));
        } else {
            sb.append(memberIdStr.substring(memberIdStr.length()-4));
        }
        return sb.toString();
    }

    @Override
    public List<SmsCouponHistoryDetail> list(Integer useStatus, Integer pages, Integer size) {
        UmsMember currentMember = memberService.getCurrentMember();
        SmsCouponHistoryExample couponHistoryExample=new SmsCouponHistoryExample();
        SmsCouponHistoryExample.Criteria criteria = couponHistoryExample.createCriteria();
        criteria.andMemberIdEqualTo(currentMember.getId());
        couponHistoryExample.setOrderByClause("create_time asc");


        PageHelper.startPage(pages, size);
        List<SmsCouponHistoryDetail> couponHistories = null;
        if (useStatus == 0){
            couponHistories = couponHistoryDao.selectEnableUseUserCoupon(currentMember.getId());
        }
        if (useStatus == 1) {
            couponHistories = couponHistoryDao.selectUsedUserCoupon(currentMember.getId());
        }
        if (useStatus == 2) {
            couponHistories = couponHistoryDao.selecteExpiredUserCoupon(currentMember.getId());
        }
        PageInfo page = new PageInfo(couponHistories);
        return page.getList();
    }

    @Override
    public List<SmsCouponHistoryDetail> listCart(List<CartPromotionItem> cartItemList, Integer type) {
        UmsMember currentMember = memberService.getCurrentMember();
        Date now = new Date();
        //获取该用户所有优惠券
        List<SmsCouponHistoryDetail> allList = couponHistoryDao.getDetailList(currentMember.getId());
        //根据优惠券使用类型来判断优惠券是否可用
        List<SmsCouponHistoryDetail> enableList = new ArrayList<>();
        List<SmsCouponHistoryDetail> disableList = new ArrayList<>();
        for (SmsCouponHistoryDetail couponHistoryDetail : allList) {
            Integer useType = couponHistoryDetail.getCoupon().getUseType();
            BigDecimal minPoint = couponHistoryDetail.getCoupon().getMinPoint();
            Date endTime = couponHistoryDetail.getCoupon().getEndTime();
            if(useType.equals(0)){
                //0->全场通用
                //判断是否满足优惠起点
                //计算购物车商品的总价
                BigDecimal totalAmount = calcTotalAmount(cartItemList);
                if(now.before(endTime)&&totalAmount.subtract(minPoint).intValue()>=0){
                    enableList.add(couponHistoryDetail);
                }else{
                    disableList.add(couponHistoryDetail);
                }
            }else if(useType.equals(1)){
                //1->指定分类
                //计算指定分类商品的总价
                List<Long> productCategoryIds = new ArrayList<>();
                for (SmsCouponProductCategoryRelation categoryRelation : couponHistoryDetail.getCategoryRelationList()) {
                    productCategoryIds.add(categoryRelation.getProductCategoryId());
                }
                BigDecimal totalAmount = calcTotalAmountByproductCategoryId(cartItemList,productCategoryIds);
                if(now.before(endTime)&&totalAmount.intValue()>0&&totalAmount.subtract(minPoint).intValue()>=0){
                    enableList.add(couponHistoryDetail);
                }else{
                    disableList.add(couponHistoryDetail);
                }
            }else if(useType.equals(2)){
                //2->指定商品
                //计算指定商品的总价
                List<Long> productIds = new ArrayList<>();
                for (SmsCouponProductRelation productRelation : couponHistoryDetail.getProductRelationList()) {
                    productIds.add(productRelation.getProductId());
                }
                BigDecimal totalAmount = calcTotalAmountByProductId(cartItemList,productIds);
                if(now.before(endTime)&&totalAmount.intValue()>0&&totalAmount.subtract(minPoint).intValue()>=0){
                    enableList.add(couponHistoryDetail);
                }else{
                    disableList.add(couponHistoryDetail);
                }
            }
        }
        if(type.equals(1)){
            return enableList;
        }else{
            return disableList;
        }
    }

    @Override
    public CommonResult couponList() {
        UmsMember currentMember = memberService.getCurrentMember();
        SmsCouponExample example = new SmsCouponExample();
        example.createCriteria().andEnableTimeLessThan(new Date())
        .andStartTimeLessThan(new Date())
        .andEndTimeGreaterThan(new Date());
        List<SmsCoupon> smsCoupons = couponMapper.selectByExample(example);
        List list = new ArrayList();
        for (SmsCoupon coupon:
        smsCoupons) {
            SmsCouponHistoryExample couponHistoryExample = new SmsCouponHistoryExample();
            couponHistoryExample.createCriteria().andCouponIdEqualTo(coupon.getId()).andMemberIdEqualTo(currentMember.getId());
            List<SmsCouponHistory> couponHistories = couponHistoryMapper.selectByExample(couponHistoryExample);
            int status = 0;
            if (couponHistories.size() >= coupon.getPerLimit()) {
                status = 1;
            }
            Map map = new HashMap();
            map.put("coupon",coupon);
            map.put("status",status);
            list.add(map);
        }
//
//
//        UmsMember currentMember = memberService.getCurrentMember();
//        List list = couponDao.getCoupons(currentMember.getId());
        return CommonResult.success(list);
    }

    private BigDecimal calcTotalAmount(List<CartPromotionItem> cartItemList) {
        BigDecimal total = new BigDecimal("0");
        for (CartPromotionItem item : cartItemList) {
            BigDecimal realPrice = item.getPrice().subtract(item.getReduceAmount());
            total=total.add(realPrice.multiply(new BigDecimal(item.getQuantity())));
        }
        return total;
    }

    private BigDecimal calcTotalAmountByproductCategoryId(List<CartPromotionItem> cartItemList,List<Long> productCategoryIds) {
        BigDecimal total = new BigDecimal("0");
        for (CartPromotionItem item : cartItemList) {
            if(productCategoryIds.contains(item.getProductCategoryId())){
                BigDecimal realPrice = item.getPrice().subtract(item.getReduceAmount());
                total=total.add(realPrice.multiply(new BigDecimal(item.getQuantity())));
            }
        }
        return total;
    }

    private BigDecimal calcTotalAmountByProductId(List<CartPromotionItem> cartItemList,List<Long> productIds) {
        BigDecimal total = new BigDecimal("0");
        for (CartPromotionItem item : cartItemList) {
            if(productIds.contains(item.getProductId())){
                BigDecimal realPrice = item.getPrice().subtract(item.getReduceAmount());
                total=total.add(realPrice.multiply(new BigDecimal(item.getQuantity())));
            }
        }
        return total;
    }

}
