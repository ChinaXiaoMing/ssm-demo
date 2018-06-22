package com.nexwise.service;

import com.nexwise.entity.Users;

import java.util.List;

/**
 * @Descript 用户业务接口
 * @Author fuyuanming
 * @Date 2018-05-07 10:06:25
 * @Version 1.0
 */
public interface UsersService {

    /**
     * 根据用户账号获取用户信息
     * @param username
     * @return
     */
    Users selectUserByUsername(String username);

    /**
     * 获取用户数据列表
     * @return
     */
    List<Users> getUserList();

    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    Users selectByPrimaryKey(Integer id);

    /**
     * 新增用户
     * @param users 用户信息
     * @return 新增数量
     */
    int addUser(Users users);

    /**
     * 更新用户
     * @param users 用户信息
     * @return 更新数量
     */
    int updateUser(Users users);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

}
