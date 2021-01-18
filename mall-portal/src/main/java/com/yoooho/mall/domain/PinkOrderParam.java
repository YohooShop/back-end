package com.yoooho.mall.domain;

public class PinkOrderParam {


    //收货地址id
    private Long memberReceiveAddressId;
    //支付方式
    private Integer payType;
    private String note;
    private Long id;

    //0直接开团，1拼团
    private int pinkType;

    //要拼团的id
    private Long pinkId;

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMemberReceiveAddressId() {
        return memberReceiveAddressId;
    }

    public void setMemberReceiveAddressId(Long memberReceiveAddressId) {
        this.memberReceiveAddressId = memberReceiveAddressId;
    }

    public Integer getPayType() {
        return payType;
    }

    public int getPinkType() {
        return pinkType;
    }

    public void setPinkType(int pinkType) {
        this.pinkType = pinkType;
    }

    public Long getPinkId() {
        return pinkId;
    }

    public void setPinkId(Long pinkId) {
        this.pinkId = pinkId;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
