package com.sea.service.impl;

import com.sea.domain.User;
import com.sea.mapper.UserMapper;
import com.sea.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
用户接口实现类
 */
@Service
public class UserServiceImpl implements UserService {
    // 注入 UserMapper 对象
    @Autowired
    private UserMapper userMapper;
    // 通过User的用户账号和用户密码查询用户信息
    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}
