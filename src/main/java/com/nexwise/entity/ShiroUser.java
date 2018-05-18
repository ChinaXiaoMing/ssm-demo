package com.nexwise.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Descript 用户角色信息
 * @Author fuyuanming
 * @Date 2018-05-18 16:17:11
 * @Version 1.0
 */
public class ShiroUser implements Serializable {
    private static final long serialVersionUID = 1L;
    //用户id
    private String userId;
    //用户名
    private String username;
    //密码
    private String password;
    //手机号
    private String mobile;
    //邮箱
    private String email;
    //出生日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public ShiroUser() {
    }

    public ShiroUser(String userId, String username, String password, String mobile, String email, Date birthday) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
        this.email = email;
        this.birthday = birthday;
    }
}
