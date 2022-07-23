package com.b.filter;

import com.b.pojo.UserDetailsImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义拦截器
 * @author zfx
 * @date 2022-07-23 11:37
 */
@Component
public class WebFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 解析请求头
        String token = request.getHeader("token");
        if(!StringUtils.hasLength(token)) {
            // 放行
            filterChain.doFilter(request,response);
            return;
        }

        // 查询redis
        // TODO
        // 构造认证对象
        var auth = new UsernamePasswordAuthenticationToken(new UserDetailsImpl(),null,null);
        // 保存到SecurityContextHolder中
        SecurityContextHolder.getContext().setAuthentication(auth);
        // 放行
        filterChain.doFilter(request,response);
    }
}
