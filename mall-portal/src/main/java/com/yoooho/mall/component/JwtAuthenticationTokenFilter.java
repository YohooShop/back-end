package com.yoooho.mall.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yoooho.mall.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JWT登录授权过滤器
 * Created by yoooho on 2019/4/26.
 */

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.refreshHeader}")
    private String refreshHeader;

    @Value("${jwt.expiration}")
    private Long expiration;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        String authHeader = request.getHeader(this.tokenHeader);
//        if (!checkIsTokenAuthorizationHeader(authHeader)){
//            log.debug("获取到认证头Authorization的值:[{}]但不是我们系统中登录后签发的。", authHeader);
//            chain.doFilter(request, response);
//            return;
//        }
//        // 获取到真实的token
//        String realToken = getRealAuthorizationToken(authHeader);
//        // 解析 jwt token
//        Jws<Claims> jws = JwtUtils.parserAuthenticateToken(realToken, secret);
//       // token 不合法
//        if (null == jws) {
//            writeJson(response, "认证token不合法");
//            return;
//        }
//        // token 是否过期
//        if (JwtUtils.isJwtExpired(jws)) {
//            // 处理过期
//            String authToken = authHeader.substring(this.tokenHead.length());
//            String username = jwtTokenUtil.getUserNameFromToken(authToken);
//            // 构建认证对象
//            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
//            jwtTokenUtil.generateToken(userDetails);
//            return;
//        }
//        // 构建认证对象
//        JwtUtils.buildAuthentication(jws, userId);
//        chain.doFilter(request, response);
        if (authHeader != null && authHeader.startsWith(this.tokenHead)) {
            String authToken = authHeader.substring(this.tokenHead.length());// The part after "Bearer "
            String username = jwtTokenUtil.getUserNameFromToken(authToken);
            LOGGER.info("checking username:{}", username);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    LOGGER.info("authenticated user:{}", username);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }

        chain.doFilter(request, response);
    }

    /**
     * 处理token过期情况
     *
     * @param response
     * @param request
     * @param filterChain
     * @return
     * @throws IOException
     */
//    private void handleTokenExpired(HttpServletResponse response, HttpServletRequest request, FilterChain filterChain) throws IOException, ServletException {
//        // 获取刷新 token
//        String refreshTokenHeader = request.getHeader(refreshHeader);
//        // 检测 refresh-token 是否是我们系统中签发的
//        if (!checkIsTokenAuthorizationHeader(refreshTokenHeader)) {
//            log.debug("获取到刷新认证头:[{}]的值:[{}]但不是我们系统中登录后签发的。", refreshHeader, refreshTokenHeader);
//            writeJson(response, "token过期了，refresh token 不是我们系统签发的");
//            return;
//        }
//        // 解析 refresh-token
//        Jws<Claims> refreshToken = JwtUtils.parserAuthenticateToken(getRealAuthorizationToken(refreshTokenHeader),
//                secret);
//        // 判断 refresh-token 是否不合法
//        if (null == refreshToken) {
//            writeJson(response, "refresh token不合法");
//            return;
//        }
//        // 判断 refresh-token 是否过期
//        if (JwtUtils.isJwtExpired(refreshToken)) {
//            writeJson(response, "refresh token 过期了");
//            return;
//        }
//        // 重新签发 token
//
//        String newToken = JwtUtils.generatorJwtToken(
//                refreshToken.getBody().get(userId),
//                userId,
//                expiration,
//                secret
//        );
//        response.addHeader(tokenHeader, newToken);
//
//        // 构建认证对象
//        JwtUtils.buildAuthentication(JwtUtils.parserAuthenticateToken(newToken, secret), userId);
//
//        filterChain.doFilter(request, response);
//    }
//
//    /**
//     *
//     */
//    /**
//     * 写 json 数据给前端
//     *
//     * @param response
//     * @throws IOException
//     */
//    private void writeJson(HttpServletResponse response, String msg) throws IOException {
//        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        response.setStatus(HttpStatus.UNAUTHORIZED.value());
//        Map<String, String> params = new HashMap<>(4);
//        params.put("msg", msg);
//        response.getWriter().print(OBJECT_MAPPER.writeValueAsString(params));
//    }
//
//    /**
//     * 获取到真实的 token 串
//     *
//     * @param authorizationToken
//     * @return
//     */
//    private String getRealAuthorizationToken(String authorizationToken) {
//        return StringUtils.substring(authorizationToken, this.tokenHead.length()).trim();
//    }
//
//
//    /**
//     * 判断是否是系统中登录后签发的token
//     *
//     * @param authorizationHeader
//     * @return
//     */
//    private boolean checkIsTokenAuthorizationHeader(String authorizationHeader) {
//        if (StringUtils.isBlank(authorizationHeader)) {
//            return false;
//        }
//        if (!StringUtils.startsWith(authorizationHeader, this.tokenHead)) {
//            return false;
//        }
//        return true;
//    }



}
