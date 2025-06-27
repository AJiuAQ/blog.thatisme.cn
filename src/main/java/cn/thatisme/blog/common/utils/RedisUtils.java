package cn.thatisme.blog.common.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import java.util.concurrent.TimeUnit;

public class RedisUtils {

    private static RedisTemplate<String, Object> redisTemplate;
    private static StringRedisTemplate stringRedisTemplate;

    // 通过配置类初始化模板（关键配置）
    public static void initTemplates(RedisTemplate<String, Object> redisTemplate,
                                     StringRedisTemplate stringRedisTemplate) {
        RedisUtils.redisTemplate = redisTemplate;
        RedisUtils.stringRedisTemplate = stringRedisTemplate;
    }

    // ================== 通用操作 ===================
    public static Boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    public static Boolean expire(String key, long seconds) {
        return redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
    }

    public static Boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    // ================== String 操作 ================
    public static void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public static void set(String key, String value, long offset) {
        stringRedisTemplate.opsForValue().set(key, value, offset, TimeUnit.SECONDS);
    }

    public static String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public static void setObject(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public static Object getObject(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // ================== Hash 操作 ==================

    public static void hPut(String key, String hashKey, Object value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    public static Object hGet(String key, String hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    // ================== 其他操作 ====================

    public Long increment(String key, long delta) {
        return stringRedisTemplate.opsForValue().increment(key, delta);
    }

    public Long decrement(String key, long delta) {
        return stringRedisTemplate.opsForValue().decrement(key, delta);
    }
}