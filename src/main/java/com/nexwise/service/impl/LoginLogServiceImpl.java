package com.nexwise.service.impl;

import com.nexwise.dao.LoginLogMapper;
import com.nexwise.entity.LoginLog;
import com.nexwise.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("LoginLogService")
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    private LoginLogMapper loginLogMapper;

    @Override
    public int insert(LoginLog loginLog) {
        return loginLogMapper.insert(loginLog);
    }
}
