package com.iflytek.settings.service;

import com.iflytek.exception.LoginException;
import com.iflytek.settings.domain.User;

/**
 * @author congchen6
 * @date 2021-12-02 10:57
 */
public interface UserService {
    User findUser(String loginAct,String loginPwd,String ip) throws LoginException;
}
