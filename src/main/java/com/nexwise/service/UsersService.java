package com.nexwise.service;

import com.nexwise.entity.Users;

public interface UsersService {

    Users selectUserByUsername(String username);

}
