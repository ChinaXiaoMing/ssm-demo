package com.nexwise.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 加密工具类
 */
public class EncryptUtil {
    //盐值
    private static final String SALT = "xiaoming";
    //加密算法
    private static final String ALGORITHM_NAME = "MD5";
    //加密次数
    private static final int COUNT = 2;

    /**
     * MD5密码加密（不加盐）
     * @param password 明文密码
     * @return 16进制密文密码
     */
    public static String encryptPasswordByPassword(String password) {
        String encryptPassword = new SimpleHash(ALGORITHM_NAME, password).toHex();
        return encryptPassword;
    }

    /**
     * MD5密码加密（密码加盐混合）
     * @param password 明文密码
     * @return 16进制密文密码
     */
    public static String saltEncryptPasswordByPassword(String password) {
        String encryptPassword = new SimpleHash(ALGORITHM_NAME, password, ByteSource.Util.bytes(SALT), COUNT).toHex();
        return encryptPassword;
    }

    /**
     * MD5密码加密（密码+账号加盐混合）
     * @param password 明文密码
     * @param username 账号
     * @return 16进制密文密码
     */
    public static String saltEncryptPasswordByPasswordAndUsername(String password, String username) {
        String encryptPassword = new SimpleHash(ALGORITHM_NAME, password, ByteSource.Util.bytes(username + SALT), COUNT).toHex();
        return encryptPassword;
    }

}
