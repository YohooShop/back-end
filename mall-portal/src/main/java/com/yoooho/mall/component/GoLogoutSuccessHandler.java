package com.yoooho.mall.component;

import cn.hutool.json.JSONUtil;
import com.yoooho.mall.common.CommonResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yoooho on 2019/8/6.
 */
public class GoLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().print(JSONUtil.parse(CommonResult.success(null,"已注销")));
        response.getWriter().flush();
    }
}
