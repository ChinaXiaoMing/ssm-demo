package com.nexwise.controller;

import com.nexwise.entity.Users;
import com.nexwise.service.UsersService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BaseController {

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi() {
        return "hello";
    }

    /**
     * 跳转到登录页面
     * @return
     */
    @GetMapping(value = {"/", "/login"})
    public String toLoginPage() {
        return "login";
    }

    /**
     * 跳转到认证失败页面
     * @return
     */
    @GetMapping("/unauthrized")
    public String toUnauthrizedPage() {
        return "unauthrized";
    }

    /**
     * 登录认证
     * @return
     */
    @PostMapping(value = "loginSubmit", produces = "application/json;charset=utf8")
    @ResponseBody
    public String loginMethod(Users users) {
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(users.getUsername(), users.getPassword());
        try {
            subject.login(token);
            return "登录成功";
        } catch (AuthenticationException e) {
            return e.getMessage();
        }
    }

}
