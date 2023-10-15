package cn.thatisme.blog.common.utils;

import cn.hutool.core.lang.Snowflake;

/**
 * <p>提供雪花id</p>
 * @author wujinhang 2023/10/7
 */
public class SnowflakeUtils {

    private static final Snowflake snowflake = new Snowflake();

    public static Snowflake snowflake() {
        return snowflake;
    }
}
