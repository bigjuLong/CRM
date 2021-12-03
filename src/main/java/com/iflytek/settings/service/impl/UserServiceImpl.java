package com.iflytek.settings.service.impl;

import com.iflytek.exception.LoginException;
import com.iflytek.settings.dao.UserDao;
import com.iflytek.settings.domain.User;
import com.iflytek.settings.service.UserService;
import com.iflytek.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author congchen6
 * @date 2021-12-02 10:57
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User findUser(String loginAct, String loginPwd, String ip) throws LoginException {
        //创建一个map，将账号密码封装进map
        Map<String,String> map=new HashMap<>();
        map.put("loginAct",loginAct);
        map.put("loginPwd",loginPwd);
        //调用dao接口
        User user=userDao.selectUser(map);
        //从user中取出lockState，allowIps，expireTime
        //验证
        if (user==null){
            throw new LoginException("账号密码错误");
        }
        //执行到这里，说明账号密码正确
        String allowIps=user.getAllowIps();
        String lockState=user.getLockState();
        String expireTime=user.getExpireTime();
        String time= DateTimeUtil.getSysTime();
        if("0".equals(lockState)){
                throw new LoginException("账号已锁定!");
        }
        if(expireTime.compareTo(time)<0){
                throw new LoginException("账号已失效!");
        }
        if (!allowIps.contains(ip)){
                throw new LoginException("ip地址受限!");
        }
        return user;
    }
}
