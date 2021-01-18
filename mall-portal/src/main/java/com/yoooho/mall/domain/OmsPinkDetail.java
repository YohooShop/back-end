package com.yoooho.mall.domain;

import com.yoooho.mall.model.OmsPink;
import com.yoooho.mall.model.OmsPinkBuyer;

public class OmsPinkDetail extends OmsPink {
    private OmsPinkBuyer pinkBuyer;

    private Integer shortPeople;

    public Integer getShortPeople() {
        return shortPeople;
    }

    public void setShortPeople(Integer shortPeople) {
        this.shortPeople = shortPeople;
    }

    public OmsPinkBuyer getPinkBuyer() {
        return pinkBuyer;
    }

    public void setPinkBuyer(OmsPinkBuyer pinkBuyer) {
        this.pinkBuyer = pinkBuyer;
    }
}
