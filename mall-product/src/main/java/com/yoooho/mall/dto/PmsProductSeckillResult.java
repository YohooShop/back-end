package com.yoooho.mall.dto;

import com.yoooho.mall.model.PmsProductSeckill;

public class PmsProductSeckillResult extends PmsProductSeckill {

    private String timeSlot;

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    private String statusStr;

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }
}
