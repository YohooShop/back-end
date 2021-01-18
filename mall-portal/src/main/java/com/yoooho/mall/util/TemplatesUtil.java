package com.yoooho.mall.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
@Component
public class TemplatesUtil {

    //模板引擎对象
    @Autowired
    private TemplateEngine templateEngine;

    // 静态初使化当前类
    public static TemplatesUtil templatesUtil;

    @Autowired
    private JavaMailSender javaMailSender;

    @PostConstruct
    public void init() {
        templatesUtil = this;
    }

    public static void  sendSimpleOrderEmail(Map<String, Object> dataMap, String from, String to){
        //获取生成的模板
        String emailText =  templatesUtil.createTemplates(dataMap, "orderEmailTemplates.html",  templatesUtil.templateEngine);
        MimeMessage message =  templatesUtil.javaMailSender.createMimeMessage();
        //消息处理助手对象
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            //设置发件人
            helper.setFrom(from);
            //设置收件人
            helper.setTo(to);
            //设置邮件标题
            helper.setSubject("主题："+ dataMap.get("title"));
            //设置邮件内容 ，true 表示发送html 格式
            helper.setText(emailText, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        templatesUtil.javaMailSender.send(message);
    }


    /**
     *
     * @param dataMap 渲染数据原
     * @param TemplatesName 模板名
     * @param templateEngine   模板操作类
     * @return
     */
    public  static String createTemplates(Map<String,Object> dataMap, String TemplatesName, TemplateEngine templateEngine){

        //context 对象用于注入要在模板上渲染的信息
        Context context = new Context();
        context.setVariables(dataMap);
        String emailText = templateEngine.process(TemplatesName,context);
        System.out.println(emailText);
        //返回模板源代码 String 类型
        return emailText;
    }

}
