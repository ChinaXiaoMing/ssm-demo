package com.nexwise.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * @Descript Jedis连接池工具类
 * @Author fuyuanming
 * @Date 2018-06-28 09:05:49
 * @Version 1.0
 */
public class JedisUtils {

    private static JedisPool jedisPool = null;
    private static String host;
    private static int port;
    private static String password;
    private static int maxIdle;
    private static int minIdle;
    private static int maxTotal;

    static {
        //加载redis.properties配置文件
        ResourceBundle resourceBundle = ResourceBundle.getBundle("redis");
        //创建Jedis连接池配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        maxIdle = Integer.parseInt(resourceBundle.getString("redis.maxIdle"));  //最大空闲连接数
        minIdle = Integer.parseInt(resourceBundle.getString("redis.minIdle"));  //最小空闲连接数
        maxTotal = Integer.parseInt(resourceBundle.getString("redis.maxTotal"));//最大连接数
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxTotal(maxTotal);
        String host = resourceBundle.getString("redis.host"); //地址
        int port = Integer.parseInt(resourceBundle.getString("redis.port"));
        //创建Jedis连接池
        jedisPool = new JedisPool(jedisPoolConfig, host, port);
    }

    /**
     * 从Jedis连接池中获取Jedis对象
     * @return
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    /**
     * 回收Jedis对象
     * @param jedis 回收对象
     */
    public static void recycleJedis(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    /**
     * 设置过期时间
     * @param key
     * @param seconds 过期时间
     */
    public static void expire(String key, int seconds) {
        if (seconds < 0) {
            return;
        }
        Jedis jedis = getJedis();
        jedis.expire(key, seconds);
        recycleJedis(jedis);
    }

}
