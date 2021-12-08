package com.iflytek.filter;

import com.iflytek.settings.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author congchen6
 * @date 2021-12-06 14:24
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       // System.out.println("验证用户访问jsp先进入doFIlter");
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        String path=request.getServletPath();
        //不应该被拦截的资源自动方形请求
        if("/login.jsp".equals(path)||"/settings/user/login.do".equals(path)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            //其他资源必须验证有没有登录过
            User user = (User) request.getSession().getAttribute("user");
            //如果user不为空，说明登录过
            if(user!=null){
                //放行
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                //没有登录过，重定向到登录页
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
