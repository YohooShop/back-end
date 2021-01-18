package com.yoooho.mall.domain;

import com.yoooho.mall.model.OmsPink;
import com.yoooho.mall.model.OmsPinkBuyer;
import com.yoooho.mall.model.PmsProductCombination;

import java.util.List;

public class OmsPinkBuyerDetail extends OmsPink {
    private List <OmsPinkBuyer> pinkBuyers;

    private Integer shortPeople;

    private PmsProductCombination goods;
    public Integer getShortPeople() {
        return shortPeople;
    }

    public void setShortPeople(Integer shortPeople) {
        this.shortPeople = shortPeople;
    }

    public List<OmsPinkBuyer> getPinkBuyers() {
        return pinkBuyers;
    }

    public void setPinkBuyers(List<OmsPinkBuyer> pinkBuyers) {
        this.pinkBuyers = pinkBuyers;
    }

    public PmsProductCombination getGoods() {
        return goods;
    }

    public void setGoods(PmsProductCombination goods) {
        this.goods = goods;
    }
}
