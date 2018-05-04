package com.nexwise.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class EncryptUtil {
    //盐值
    private static final String SALT = "xiaoming";
    //加密算法
    private static final String ALGORITHM_NAME = "MD5";
    //加密次数
    private static final int COUNT = 2;

    public static String encryptPasswordMethod(String password, String username) {
        String encryptPassword = new SimpleHash(ALGORITHM_NAME, password, ByteSource.Util.bytes(username + SALT), COUNT).toHex();
        return encryptPassword;
    }

}
