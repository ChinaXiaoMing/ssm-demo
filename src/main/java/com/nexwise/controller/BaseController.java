package com.nexwise.controller;

import com.nexwise.entity.Users;
import com.nexwise.service.UsersService;
import com.nexwise.util.EncryptUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Descript 业务控制类
 * @Author fuyuanming
 * @Date 2018-05-07 10:01:40
 * @Version 1.0
 */
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

    @GetMapping("success")
    public String toSuccessPage() {
        return "success";
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
    public String loginMethod(Users users) {
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        String encryptPassword = EncryptUtil.saltEncryptPasswordByPasswordAndUsername(users.getPassword(), users.getUsername());
        UsernamePasswordToken token = new UsernamePasswordToken(users.getUsername(), encryptPassword);
        try {
            System.out.println(subject.getSession().getId());
            System.out.println(subject.getSession().getHost());
            System.out.println(subject.getSession().getTimeout());
            subject.login(token);
            return "redirect:/success";
        } catch (AuthenticationException e) {
            return "redirect:/unanthrized";
        }
    }

}
