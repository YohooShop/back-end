package com.yoooho.mall.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yoooho.mall.common.utils.WXAuthUtil;
import com.yoooho.mall.service.WXService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WXServiceImpl implements WXService {
    @Override
    public Object getAuthCode2Session(String appid, String secret, String code) {

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid
                + "&secret="+secret
                + "&js_code="+code
                + "&grant_type=authorization_code";

        JSONObject jsonObject = null;
        try {
            jsonObject = WXAuthUtil.doGetJson(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    @Override
    public Object getAuthCode2Token(String appid, String secret, String code) {
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid
                + "&secret="+secret
                + "&code="+code
                + "&grant_type=authorization_code";
        JSONObject jsonObject = null;
        try {
            jsonObject = WXAuthUtil.doGetJson(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
