package com.nexwise.controller;

import com.alibaba.fastjson.JSON;
import com.nexwise.entity.Users;
import com.nexwise.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Descript 用户控制器
 * @Author fuyuanming
 * @Date 2018-06-06 15:13:30
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UsersService usersService;

    /**
     * 获取用户信息列表
     * @return 用户列表数据
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getUserList() {
        List<Users> usersList = usersService.getUserList();
        String json = JSON.toJSONString(usersList);
        return json;
    }

    /**
     * 根据id查询用户
     * @param id 用户id
     * @return 用户信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable Integer id) {
        String json = JSON.toJSONString(usersService.selectByPrimaryKey(id));
        return json;
    }

    /**
     * 新增用户
     * @param users 用户实体类
     * @return 新增结果
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addUser(Users users) {
        System.out.println(users.getUsername());
        int addCount = usersService.addUser(users);
        if (addCount > 0) {
            return "add success";
        } else {
            return "add failure";
        }
    }

    /**
     * 更新用户数据
     * @param id 用户id
     * @param users 表单提交的用户数据
     * @return 更新结果
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateUserById(@PathVariable Integer id, @ModelAttribute Users users) {
        Users newUser = usersService.selectByPrimaryKey(id);
        newUser.setUsername(users.getUsername());
        newUser.setPassword(users.getPassword());
        int updateCount = usersService.updateUser(users);
        if (updateCount > 0) {
            return "update success";
        } else {
            return "update failure";
        }
    }

    /**
     * 根据id删除用户数据
     * @param id 待删除用户id
     * @return 删除结果
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUserById(@PathVariable Integer id) {
        int deleteCount = usersService.deleteByPrimaryKey(id);
        if (deleteCount > 0) {
            return "delete success";
        } else {
            return "delete failure";
        }

    }

}
