package com.nexwise.controller;

import com.google.code.kaptcha.Constants;
import com.nexwise.entity.Users;
import com.nexwise.utils.EncryptUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Descript 登录操作控制层
 * @Author fuyuanming
 * @Date 2018-05-07 10:01:40
 * @Version 1.0
 */
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * 跳转到登录页面
     * @return
     */
    @GetMapping(value = {"/", "/login"})
    public String toLoginPage() {
        return "login";
    }

    @GetMapping("/success")
    public String toSuccessPage() {
        return "success";
    }

    @GetMapping(value = "/index")
    public String toIndexPage() {
        return "index";
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
     * @param users 前端用户登录信息
     * @return
     */
    @RequestMapping(value = "/loginSubmit")
    @ResponseBody
    public String loginMethod(Users users) {
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        String encryptPassword = EncryptUtils.saltEncryptPasswordByPasswordAndUsername(users.getPassword(), users.getUsername());
        UsernamePasswordToken token = new UsernamePasswordToken(users.getUsername(), encryptPassword);
        //获取Kaptcha验证码
        //String kaptchaCode = (String) subject.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        try {
            //登录认证
            subject.login(token);
            return "success";
//            if (kaptchaCode.equals(captcha)) {
//                return "success";  //登录成功
//            } else {
//                return "captchaError"; //验证码错误
//            }
        } catch (UnknownAccountException e) { //账号不存在
            return "unknownAccount";
        } catch (IncorrectCredentialsException e) { //密码错误
            return "passwordError";
        } catch (AuthenticationException e) { //其他认证错误
            return "unknownException";
        }
    }

}
