package com.yoooho.mall.dto;
import com.alibaba.fastjson.annotation.JSONField;

public class SessionDTO {
    private String openid;

    @JSONField(name = "session_key")
    private String sessionKey;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}
