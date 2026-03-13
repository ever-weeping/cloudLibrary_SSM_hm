package com.sea.service;

import com.sea.domain.User;

public interface UserService {
    // 通过 User 的用户账号和用户密码查询用户信息
    User login(User user);
}
