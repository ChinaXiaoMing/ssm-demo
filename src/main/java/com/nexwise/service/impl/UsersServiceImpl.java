package com.nexwise.service.impl;

import com.nexwise.dao.UsersMapper;
import com.nexwise.entity.Users;
import com.nexwise.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UsersService")
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersMapper usersMapper;

    @Override
    public Users selectUserByUsername(String username) {
        return usersMapper.selectUserByUsername(username);
    }
}
