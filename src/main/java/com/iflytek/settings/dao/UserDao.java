package com.iflytek.settings.dao;

import com.iflytek.settings.domain.User;

import java.util.Map;

/**
 * @author congchen6
 * @date 2021-12-02 10:52
 */
public interface UserDao {
    User selectUser(Map<String ,String> map);
}
