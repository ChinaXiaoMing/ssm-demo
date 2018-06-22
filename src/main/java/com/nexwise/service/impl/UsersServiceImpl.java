package com.nexwise.service.impl;

import com.nexwise.dao.UsersMapper;
import com.nexwise.entity.Users;
import com.nexwise.service.UsersService;
import com.nexwise.utils.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UsersService")
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersMapper usersMapper;

    /**
     * 根据用户账号获取用户信息
     * @param username
     * @return
     */
    @Override
    public Users selectUserByUsername(String username) {
        return usersMapper.selectUserByUsername(username);
    }

    /**
     * 获取用户数据列表
     * @return
     */
    @Override
    public List<Users> getUserList() {
        return usersMapper.getUserList();
    }

    /**
     * 根据用户id获取用户信息
     * @param id 用户id
     * @return 用户信息
     */
    @Override
    public Users selectByPrimaryKey(Integer id) {
        return usersMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增用户
     * @param users 用户信息
     * @return 新增数量
     */
    @Override
    public int addUser(Users users) {
        users.setPassword(EncryptUtils.saltEncryptPasswordByPasswordAndUsername(users.getPassword(), users.getUsername()));
        System.out.println(users.getPassword());
        return usersMapper.insertSelective(users);
    }

    /**
     * 更新用户
     * @param users 用户信息
     * @return 更新数量
     */
    @Override
    public int updateUser(Users users) {
        return usersMapper.updateByPrimaryKeySelective(users);
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return usersMapper.deleteByPrimaryKey(id);
    }
}
