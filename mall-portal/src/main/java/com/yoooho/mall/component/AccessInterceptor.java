package com.yoooho.mall.component;

import com.yoooho.mall.access.AccessKey;
import com.yoooho.mall.access.AccessLimit;
import com.yoooho.mall.model.UmsMember;
import com.yoooho.mall.service.RedisService;
import com.yoooho.mall.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class AccessInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    UmsMemberService memberService;
    @Autowired
    RedisService redisService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
            if (accessLimit == null) {
                return true;
            }
           UmsMember user = memberService.getCurrentMember();
            int seconds = accessLimit.seconds();
            int maxCount = accessLimit.maxCount();
            boolean login = accessLimit.needLogin();
            String key = request.getRequestURI();
            if (login) {
                //login
                if(user == null) {
                    render(response, "用户未登录");
                    return false;
                }
                key += "_" + user.getId();
            }else {
                //do nothing
            }

            AccessKey ak = AccessKey.withExpire(seconds);
            Integer count = redisService.get(ak, key, Integer.class);
            if(count  == null) {
                redisService.set(ak, key, 1);
            }else if(count < maxCount) {
                redisService.incr(ak, key, count +1);
            }else {
                render(response, "超过访问次数了");
                return false;
            }
        }
        return true;
    }
    private void render(HttpServletResponse response, String string) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        out.write(string.getBytes());
        out.flush();
        out.close();
    }
}
