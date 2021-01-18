package com.yoooho.mall.dto;

import java.math.BigDecimal;

public class HomeData {
    //今日订单数目
    private int today_order_number;
    //今日销售总额
    private  BigDecimal today_total_sales;
    //昨日销售总额
    private  BigDecimal yesterday_total_sales;

    //代付款数目
    private  int wait_pay_number;
    //代发货订单数目
    private  int wait_deliver_number;
    //已发货订单数目
    private int delivered_number;
    //已完成订单数目
    private int complete_order_number;
    //新缺货登记数目
    private  int out_stock_number;
    //待处理退货订单数目
    private int wait_deal_return_goods_number;
    //待确认收货数目
    private int wait_confirm_receipt_number;
    //待处理退款申请数目
    private  int wait_deal_refund_number;
    //广告位即将到期数目
    private  int expired_ad_number;

    //商品已下架数目
    private int undercarriage_goods_number;
    //商品已上架数目
    private int grounding_goods_number;
    //库存紧张数目
    private int tight_stock_goods_number;
    //全部商品数目
    private int all_goods_number;

    //用户今日新增数目
    private int today_newUser_number;
    //用户昨日新增数目
    private int yesterday_newUser_number;
    //用户本月新增数目
    private int current_month_newUser_number;
    //会员总数数目
    private int usersCount;

    //本月订单总数
    private int current_month_orders_count;
    //本周订单总数
    private int current_week_orders_count;
    //本月销售总额
    private BigDecimal current_month_sales_count;
    //本周销售总额
    private  BigDecimal current_week_sales_count;

    //本月订单升降百分比
    private String monthOrderPercentage;
    private  boolean upMonthOrderPercentage;

    //本周订单升降百分比
    private String weekOrderPercentage;
    private boolean upWeekOrderPercentage;

    //本月销售升降百分比
    private  String monthSalesPercentage;
    private boolean upMonthSalesPercentage;

    //本周销售升降百分比
    private String weekSalesPercentage;
    private boolean upWeekSalesPercentage;


    public int getToday_order_number() {
        return today_order_number;
    }

    public void setToday_order_number(int today_order_number) {
        this.today_order_number = today_order_number;
    }

    public BigDecimal getToday_total_sales() {
        return today_total_sales;
    }

    public void setToday_total_sales(BigDecimal today_total_sales) {
        this.today_total_sales = today_total_sales;
    }

    public BigDecimal getYesterday_total_sales() {
        return yesterday_total_sales;
    }

    public void setYesterday_total_sales(BigDecimal yesterday_total_sales) {
        this.yesterday_total_sales = yesterday_total_sales;
    }

    public int getWait_pay_number() {
        return wait_pay_number;
    }

    public void setWait_pay_number(int wait_pay_number) {
        this.wait_pay_number = wait_pay_number;
    }

    public int getWait_deliver_number() {
        return wait_deliver_number;
    }

    public void setWait_deliver_number(int wait_deliver_number) {
        this.wait_deliver_number = wait_deliver_number;
    }

    public int getDelivered_number() {
        return delivered_number;
    }

    public void setDelivered_number(int delivered_number) {
        this.delivered_number = delivered_number;
    }

    public int getComplete_order_number() {
        return complete_order_number;
    }

    public void setComplete_order_number(int complete_order_number) {
        this.complete_order_number = complete_order_number;
    }

    public int getOut_stock_number() {
        return out_stock_number;
    }

    public void setOut_stock_number(int out_stock_number) {
        this.out_stock_number = out_stock_number;
    }

    public int getWait_deal_return_goods_number() {
        return wait_deal_return_goods_number;
    }

    public void setWait_deal_return_goods_number(int wait_deal_return_goods_number) {
        this.wait_deal_return_goods_number = wait_deal_return_goods_number;
    }

    public int getWait_confirm_receipt_number() {
        return wait_confirm_receipt_number;
    }

    public void setWait_confirm_receipt_number(int wait_confirm_receipt_number) {
        this.wait_confirm_receipt_number = wait_confirm_receipt_number;
    }

    public int getWait_deal_refund_number() {
        return wait_deal_refund_number;
    }

    public void setWait_deal_refund_number(int wait_deal_refund_number) {
        this.wait_deal_refund_number = wait_deal_refund_number;
    }

    public int getExpired_ad_number() {
        return expired_ad_number;
    }

    public void setExpired_ad_number(int expired_ad_number) {
        this.expired_ad_number = expired_ad_number;
    }

    public int getUndercarriage_goods_number() {
        return undercarriage_goods_number;
    }

    public void setUndercarriage_goods_number(int undercarriage_goods_number) {
        this.undercarriage_goods_number = undercarriage_goods_number;
    }

    public int getGrounding_goods_number() {
        return grounding_goods_number;
    }

    public void setGrounding_goods_number(int grounding_goods_number) {
        this.grounding_goods_number = grounding_goods_number;
    }

    public int getTight_stock_goods_number() {
        return tight_stock_goods_number;
    }

    public void setTight_stock_goods_number(int tight_stock_goods_number) {
        this.tight_stock_goods_number = tight_stock_goods_number;
    }

    public int getAll_goods_number() {
        return all_goods_number;
    }

    public void setAll_goods_number(int all_goods_number) {
        this.all_goods_number = all_goods_number;
    }

    public int getToday_newUser_number() {
        return today_newUser_number;
    }

    public void setToday_newUser_number(int today_newUser_number) {
        this.today_newUser_number = today_newUser_number;
    }

    public int getYesterday_newUser_number() {
        return yesterday_newUser_number;
    }

    public void setYesterday_newUser_number(int yesterday_newUser_number) {
        this.yesterday_newUser_number = yesterday_newUser_number;
    }

    public int getCurrent_month_newUser_number() {
        return current_month_newUser_number;
    }

    public void setCurrent_month_newUser_number(int current_month_newUser_number) {
        this.current_month_newUser_number = current_month_newUser_number;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public int getCurrent_month_orders_count() {
        return current_month_orders_count;
    }

    public void setCurrent_month_orders_count(int current_month_orders_count) {
        this.current_month_orders_count = current_month_orders_count;
    }

    public int getCurrent_week_orders_count() {
        return current_week_orders_count;
    }

    public void setCurrent_week_orders_count(int current_week_orders_count) {
        this.current_week_orders_count = current_week_orders_count;
    }

    public BigDecimal getCurrent_month_sales_count() {
        return current_month_sales_count;
    }

    public void setCurrent_month_sales_count(BigDecimal current_month_sales_count) {
        this.current_month_sales_count = current_month_sales_count;
    }

    public BigDecimal getCurrent_week_sales_count() {
        return current_week_sales_count;
    }

    public void setCurrent_week_sales_count(BigDecimal current_week_sales_count) {
        this.current_week_sales_count = current_week_sales_count;
    }

    public String getMonthOrderPercentage() {
        return monthOrderPercentage;
    }

    public void setMonthOrderPercentage(String monthOrderPercentage) {
        this.monthOrderPercentage = monthOrderPercentage;
    }

    public boolean isUpMonthOrderPercentage() {
        return upMonthOrderPercentage;
    }

    public void setUpMonthOrderPercentage(boolean upMonthOrderPercentage) {
        this.upMonthOrderPercentage = upMonthOrderPercentage;
    }

    public String getWeekOrderPercentage() {
        return weekOrderPercentage;
    }

    public void setWeekOrderPercentage(String weekOrderPercentage) {
        this.weekOrderPercentage = weekOrderPercentage;
    }

    public boolean isUpWeekOrderPercentage() {
        return upWeekOrderPercentage;
    }

    public void setUpWeekOrderPercentage(boolean upWeekOrderPercentage) {
        this.upWeekOrderPercentage = upWeekOrderPercentage;
    }

    public String getMonthSalesPercentage() {
        return monthSalesPercentage;
    }

    public void setMonthSalesPercentage(String monthSalesPercentage) {
        this.monthSalesPercentage = monthSalesPercentage;
    }

    public boolean isUpMonthSalesPercentage() {
        return upMonthSalesPercentage;
    }

    public void setUpMonthSalesPercentage(boolean upMonthSalesPercentage) {
        this.upMonthSalesPercentage = upMonthSalesPercentage;
    }

    public String getWeekSalesPercentage() {
        return weekSalesPercentage;
    }

    public void setWeekSalesPercentage(String weekSalesPercentage) {
        this.weekSalesPercentage = weekSalesPercentage;
    }

    public boolean isUpWeekSalesPercentage() {
        return upWeekSalesPercentage;
    }

    public void setUpWeekSalesPercentage(boolean upWeekSalesPercentage) {
        this.upWeekSalesPercentage = upWeekSalesPercentage;
    }
}
