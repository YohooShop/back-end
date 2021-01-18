package com.yoooho.mall.dto;

import com.yoooho.mall.domian.WechatReply;

public class WechatReplyParams extends WechatReply {

    private String contentStr;

    public String getContentStr() {
        return contentStr;
    }

    public void setContentStr(String contentStr) {
        this.contentStr = contentStr;
    }
}
