package com.yoooho.mall.utils;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.yoooho.mall.domian.SmsTemplate;

public class AliyunSms {
    public static boolean sendSms(String phoneNumbers, SmsTemplate smsTemplate, String content){
        boolean sendSucessed = sendMsm(phoneNumbers,smsTemplate, content);
        return sendSucessed;
    }


    public static   boolean sendMsm(String phoneNumbers,  SmsTemplate smsTemplate, String content) {
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）

        final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        } catch (ClientException e) {
            e.printStackTrace();
            return false;
        }
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", smsTemplate.getAccessKeyId(), smsTemplate.getAccesSecret());
        IAcsClient client = new DefaultAcsClient(profile);
        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        request.setMethod(MethodType.POST);
        //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为00+国际区号+号码，如“0085200000000”
        request.setPhoneNumbers(phoneNumbers);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(smsTemplate.getSignName());
        //必填:短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
        request.setTemplateCode(smsTemplate.getTemplateCode());
        request.setTemplateParam(content);
//        request.setTemplateParam("{ \"code\":"+smsCode + "}");
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = client.getAcsResponse(request);
            if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
                //请求成功
                return true;
            }else {
                return false;
            }
        } catch (ClientException e) {
            e.printStackTrace();
            return false;
        }
    }
}
