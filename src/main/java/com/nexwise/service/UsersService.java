package com.nexwise.service;

import com.nexwise.entity.Users;

/**
 * @Descript 用户业务接口
 * @Author fuyuanming
 * @Date 2018-05-07 10:06:25
 * @Version 1.0
 */
public interface UsersService {

    Users selectUserByUsername(String username);

}
