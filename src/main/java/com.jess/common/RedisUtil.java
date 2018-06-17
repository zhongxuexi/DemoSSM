package com.jess.common;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by zhongxuexi on 2018/6/17.
 */
public class RedisUtil {
    private static JedisPool jedisPool = null;
    /**
     * 初始化redis连接池
     */
    private static void init() {
        JedisPoolConfig config = new JedisPoolConfig(); // Jedis连接池
        config.setMaxIdle(8); // 最大空闲连接数
        config.setMaxTotal(8);// 最大连接数
        config.setMaxWaitMillis(1000); // 获取连接是的最大等待时间，如果超时就抛出异常
        config.setTestOnBorrow(false);// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
        config.setTestOnReturn(true);
        jedisPool = new JedisPool(config, "192.168.0.188", 6379, 5000, "jess", 0); // 配置、ip、端口、连接超时时间、密码、数据库编号（0~15）
    }

    /**
     * string类型的基本操作，string是redis的最基本数据类型，很多操作都是其他数据类型能用的，如del、exists、expire
     *
     * @throws Exception
     *
     */
    private static void string() throws Exception {
        Jedis jedis = jedisPool.getResource();
        jedis.flushDB(); // 清空数据库

    }
}
