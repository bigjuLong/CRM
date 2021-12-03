package com.iflytek.settings.controller;

import com.iflytek.exception.LoginException;
import com.iflytek.settings.domain.User;
import com.iflytek.settings.service.UserService;
import com.iflytek.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author congchen6
 * @date 2021-12-02 11:01
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login.do")
    @ResponseBody
    public Map<String ,Object> doLogin(HttpServletRequest request,String loginAct,String loginPwd){
        //接受账号密码
        /*String loginAct=request.getParameter("loginAct");
        String loginPwd=request.getParameter("loginPwd");*/
        //将密码加密
        loginPwd= MD5Util.getMD5(loginPwd);
        //接受请求ip地址
        String ip=request.getRemoteAddr();
        System.out.println("ip======"+ip);
        //创建Service对象，调用service方法
        Map<String ,Object> map=new HashMap<>();
        try {
            User user=userService.findUser(loginAct,loginPwd,ip);
            request.getSession().setAttribute("user",user);
            //执行到这，说明业务层没有抛异常，给前端返回一个success:true
            map.put("success",true);
            return map;
        } catch (LoginException e) {
            e.printStackTrace();
            //程序执行到这，说明业务层抛了个异常
            String msg=e.getMessage();
            map.put("success",false);
            map.put("msg",msg);
            return map;
        }
    }
}
