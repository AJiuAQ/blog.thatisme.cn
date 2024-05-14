package cn.thatisme.blog.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class EnvFileUtils {

    private static final Logger logger = LoggerFactory.getLogger(EnvFileUtils.class);

    /**
     * 默认路径 取系统用户路径
     * windows 默认为 C:/Users/{用户名}
     * linux root 用户默认为 /root
     */
    private static final String DEFAULT_FILE_NAME = System.getProperty("user.home") + File.separator + ".env";

    private static final Map<String, Properties> propertiesMap = new HashMap<>();

    public static Map<String, Object> getProperties(String fileName) {
        Properties properties = propertiesMap.get(fileName);
        if (properties == null) {
            properties = new Properties();
            try {
                properties.load(new FileReader(fileName));
                logger.info("获取配置文件成功：" + DEFAULT_FILE_NAME);
            } catch (IOException e) {
                logger.warn("获取配置文件失败：" + e.getMessage());
            }
            propertiesMap.put(fileName, properties);
        }
        Map<String, Object> result = new HashMap<>();
        for (String stringPropertyName : properties.stringPropertyNames()) {
            result.put(stringPropertyName, properties.getProperty(stringPropertyName));
        }
        return result;
    }

    public static Map<String, Object> getProperties() {
        return getProperties(DEFAULT_FILE_NAME);
    }
}