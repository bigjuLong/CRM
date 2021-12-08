package com.iflytek.handler;

import com.iflytek.settings.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author congchen6
 * @date 2021-12-06 15:33
 */
public class LoginIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       User user= (User) request.getSession().getAttribute("user");
       if (user!=null){
           //用户登录过，放行
           return true;
       }else {
           response.sendRedirect(request.getContextPath()+"/login.jsp");
           return false;
       }
    }
}
