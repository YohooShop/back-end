package com.yoooho.mall.service;

public interface WXService {

    Object getAuthCode2Session(String appid, String secret, String code);

    Object getAuthCode2Token(String appid, String secret, String code);

}
