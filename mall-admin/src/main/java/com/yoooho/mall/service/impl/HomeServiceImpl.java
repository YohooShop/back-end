package com.yoooho.mall.service.impl;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.dto.HomeData;
import com.yoooho.mall.mapper.OmsOrderMapper;
import com.yoooho.mall.mapper.OmsOrderReturnApplyMapper;
import com.yoooho.mall.mapper.PmsProductMapper;
import com.yoooho.mall.mapper.UmsMemberMapper;
import com.yoooho.mall.model.*;
import com.yoooho.mall.model.*;
import com.yoooho.mall.util.DateUtil;
import com.yoooho.mall.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    OmsOrderMapper omsOrderMapper;
    @Autowired
    OmsOrderReturnApplyMapper orderReturnApplyMapper;
    @Autowired
    PmsProductMapper pmsProductMapper;

    @Autowired
    UmsMemberMapper memberMapper;
    @Override
    public CommonResult homeData() {
        HomeData homeData = new HomeData();
        //今日订单数目
        int todayOrderCount = getTodayOrderNumber();
        homeData.setToday_order_number(todayOrderCount);
        //今日销售总额
        homeData.setToday_total_sales(getTodayTotalSales());

        //昨日销售总额
        homeData.setYesterday_total_sales(getYesterdayTotalSales());

        //代付款数目
        homeData.setWait_pay_number(orderStatusCount(0));
        //代发货订单数目
        homeData.setWait_pay_number(orderStatusCount(1));
        //已经发送订单数目
        homeData.setWait_pay_number(orderStatusCount(2));
        //已完成订单数目
        homeData.setWait_pay_number(orderStatusCount(3));
        //新缺货登记数目
        //待处理退货订单数目
        homeData.setWait_deliver_number(deliverStatusCount(0));
        //待确认收货数目
        homeData.setWait_confirm_receipt_number(orderStatusCount(2));
        //待处理退款申请数目

        //广告位即将到期数目

        //商品已下架数目
        homeData.setUndercarriage_goods_number(getProductPublishStatusCount(1));
        //商品已上架数目
        homeData.setGrounding_goods_number(getProductPublishStatusCount(0));
        //库存紧张数目

        //全部商品数目
        homeData.setAll_goods_number(getProductPublishStatusCount(-1));
        //用户今日新增数目
        homeData.setToday_newUser_number(getTodayNewUser());
        //用户昨日新增数目
        homeData.setYesterday_newUser_number(getYesterdayNewUser());
        //用户本月新增数目

        homeData.setCurrent_month_newUser_number(getMonthNewUser());
        //会员总数数目
        homeData.setUsersCount(getUserCount());


        //本月订单总数
        homeData.setCurrent_month_orders_count(getMonthOrder());
        //本周订单总数
        homeData.setCurrent_week_orders_count(getWeekOrder());
        //本月销售总额
        homeData.setCurrent_month_sales_count(getMonthSales());
        //本周销售总额
        homeData.setCurrent_week_sales_count(getWeekSales());

        homeData.setMonthOrderPercentage(getMonthOrderPercentage());
        if (homeData.getMonthOrderPercentage().contains("+")){
            homeData.setUpMonthOrderPercentage(true);
        }else {
            homeData.setUpMonthOrderPercentage(false);
        }

        homeData.setWeekOrderPercentage(getWeekOrderPercentage());
        if (homeData.getWeekOrderPercentage().contains("+")){
            homeData.setUpWeekOrderPercentage(true);
        }else {
            homeData.setUpWeekOrderPercentage(false);
        }

        homeData.setMonthSalesPercentage(getMonthSalesPercentage());
        if (homeData.getMonthSalesPercentage().contains("+")){
            homeData.setUpMonthSalesPercentage(true);
        }else {
            homeData.setUpMonthSalesPercentage(false);
        }

        homeData.setWeekSalesPercentage(getWeekSalesPercentage());
        if (homeData.getWeekSalesPercentage().contains("+")){
            homeData.setUpWeekSalesPercentage(true);
        }else {
            homeData.setUpWeekSalesPercentage(false);
        }

        return CommonResult.success(homeData);
    }

    @Override
    public CommonResult statisticsData(Long beginDate,Long endDate) {

        return null;
    }

    private int getTodayOrderNumber(){
        OmsOrderExample omsOrderExample = new OmsOrderExample();
        omsOrderExample.createCriteria().andPaymentTimeBetween(DateUtil.getDayBegin(),DateUtil.getDayEnd()).andPayTypeNotEqualTo(0);
        return  omsOrderMapper.selectByExample(omsOrderExample).size();
    }

    private BigDecimal getTodayTotalSales(){
        return getSalesBetweenTime(DateUtil.getDayBegin(),DateUtil.getDayEnd());
    }
    private BigDecimal getYesterdayTotalSales(){
        return getSalesBetweenTime(DateUtil.getBeginDayOfYesterday(),DateUtil.getEndDayOfYesterDay());
    }

    private int orderStatusCount(int status){
        OmsOrderExample omsOrderExample = new OmsOrderExample();
        omsOrderExample.createCriteria().andStatusEqualTo(status);
        List<OmsOrder> omsOrders = omsOrderMapper.selectByExample(omsOrderExample);
        return omsOrders.size();
    }

    private  int deliverStatusCount(int status){
        OmsOrderReturnApplyExample omsOrderReturnApplyExample = new OmsOrderReturnApplyExample();
        omsOrderReturnApplyExample.createCriteria().andStatusEqualTo(status);
        return orderReturnApplyMapper.selectByExample(omsOrderReturnApplyExample).size();
    }

    private  int getProductPublishStatusCount(int publish_status){
        PmsProductExample example = new PmsProductExample();
        if (publish_status != -1){
            example.createCriteria().andPublishStatusEqualTo(publish_status);
        }else {
            example.createCriteria();
        }
        return pmsProductMapper.selectByExample(example).size();
    }
    public int getTodayNewUser() {
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andCreateTimeBetween(DateUtil.getDayBegin(),DateUtil.getDayEnd());
        return memberMapper.selectByExample(example).size();
    }

    private  int getYesterdayNewUser(){
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andCreateTimeBetween(DateUtil.getBeginDayOfYesterday(),DateUtil.getEndDayOfYesterDay());
        return memberMapper.selectByExample(example).size();
    }

    private  int getMonthNewUser() {
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andCreateTimeBetween(DateUtil.getBeginDayOfMonth(),DateUtil.getEndDayOfMonth());
        return memberMapper.selectByExample(example).size();
    }
    private int getUserCount(){
        UmsMemberExample example = new UmsMemberExample();
        return memberMapper.selectByExample(example).size();
    }

    private int getMonthOrder(){
        OmsOrderExample omsOrderExample = new OmsOrderExample();
        omsOrderExample.createCriteria().andPaymentTimeBetween(DateUtil.getBeginDayOfMonth(),DateUtil.getEndDayOfMonth()).andPayTypeNotEqualTo(0);
        return  omsOrderMapper.selectByExample(omsOrderExample).size();
    }
    private int getLastMonthOrder(){
        OmsOrderExample omsOrderExample = new OmsOrderExample();
        omsOrderExample.createCriteria().andPaymentTimeBetween(DateUtil.getBeginDayOfLastMonth(),DateUtil.getEndDayOfLastMonth()).andPayTypeNotEqualTo(0);
        return  omsOrderMapper.selectByExample(omsOrderExample).size();
    }
    private int getWeekOrder(){
        OmsOrderExample omsOrderExample = new OmsOrderExample();
        omsOrderExample.createCriteria().andPaymentTimeBetween(DateUtil.getBeginDayOfWeek(),DateUtil.getEndDayOfWeek()).andPayTypeNotEqualTo(0);
        return  omsOrderMapper.selectByExample(omsOrderExample).size();
    }
    private int getLastWeekOrder(){
        OmsOrderExample omsOrderExample = new OmsOrderExample();
        omsOrderExample.createCriteria().andPaymentTimeBetween(DateUtil.getBeginDayOfLastWeek(),DateUtil.getEndDayOfLastWeek()).andPayTypeNotEqualTo(0);
        return  omsOrderMapper.selectByExample(omsOrderExample).size();
    }

    private BigDecimal getMonthSales(){
      return  getSalesBetweenTime(DateUtil.getBeginDayOfMonth(),DateUtil.getEndDayOfMonth());
    }

    private BigDecimal getLastMonthSales(){
        return  getSalesBetweenTime(DateUtil.getBeginDayOfLastMonth(),DateUtil.getEndDayOfLastMonth());
    }

    private BigDecimal getWeekSales(){
        return getSalesBetweenTime(DateUtil.getBeginDayOfWeek(),DateUtil.getEndDayOfWeek());
    }

    private BigDecimal getLastWeekSales(){
        return getSalesBetweenTime(DateUtil.getBeginDayOfLastMonth(),DateUtil.getEndDayOfLastWeek());
    }

    BigDecimal getSalesBetweenTime(Date beginDate, Date endDate) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        OmsOrderExample omsOrderExample = new OmsOrderExample();
        omsOrderExample.createCriteria().andPaymentTimeBetween(beginDate,endDate).andPayTypeIn(list);
        List<OmsOrder> omsOrders = omsOrderMapper.selectByExample(omsOrderExample);
        BigDecimal amount = new BigDecimal("0");;
        for (int i = 0; i <omsOrders.size() ; i++) {
            amount  =  amount.add(omsOrders.get(i).getPayAmount());
        }
        return amount;
    }

    String getMonthOrderPercentage(){
        int monthOrderCount = getMonthOrder();
        int lastMonthOrderCount =getLastMonthOrder();
        String result;
        if (monthOrderCount>=lastMonthOrderCount){
            result = "+" + accuracy(monthOrderCount - lastMonthOrderCount,lastMonthOrderCount,1000);
        }else {
            result = "-" + accuracy(lastMonthOrderCount - monthOrderCount,lastMonthOrderCount,1000);
        }
        return result;
    }
    String getWeekOrderPercentage(){
        int weekOrderCount = getWeekOrder();
        int lastWeekOrderCount = getLastWeekOrder();
        String result;
        if (weekOrderCount>=lastWeekOrderCount){

            result = "+" +  accuracy(weekOrderCount - lastWeekOrderCount,lastWeekOrderCount,1);
        }else {

            result = "-" +  accuracy( lastWeekOrderCount - weekOrderCount,lastWeekOrderCount,1);
        }
        return result;
    }
    String getMonthSalesPercentage(){
       float monthSales = getMonthSales().floatValue();
       float lastMonthSales = getLastMonthSales().floatValue();
        String result;
        if (monthSales>=lastMonthSales){
            result = "+" + accuracy(monthSales - lastMonthSales, lastMonthSales,1);
        }else {
            result = "-" + accuracy(lastMonthSales - monthSales, lastMonthSales,1);
        }
        return result;
    }
    String getWeekSalesPercentage(){
        float weekSales = getWeekSales().floatValue();
        float lastWeekSales = getLastWeekSales().floatValue();
        String result;
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        if (weekSales>=lastWeekSales){
            result = "+" + accuracy(weekSales - lastWeekSales, lastWeekSales, 1);
        }else {
            result ="-" + accuracy(lastWeekSales - weekSales, lastWeekSales, 1);
        }
        return result;
    }



    private String accuracy(double num, double total, int scale){
        DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();
        //可以设置精确几位小数
        df.setMaximumFractionDigits(scale);
        //模式 例如四舍五入
        df.setRoundingMode(RoundingMode.HALF_UP);
        double accuracy_num;
        if (total == 0){
            accuracy_num = num;
        }else {
            accuracy_num = num / total * 100;
        }

        String result = df.format(accuracy_num)+"%";
        System.out.println(result);
        return result;
    }



}
