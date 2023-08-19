package cn.thatisme.blog.common.utils;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 * @author wujinhang 2023/8/19
 */
@Getter
@Service
public class SpringContextHolder implements ApplicationContextAware {
    /**
     * spring上下文
     */
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(@Nonnull ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }

    /**
     * 获取bean
     * @param requiredType bean类型
     * @param <T> bean
     * @return bean
     */
    public static <T> T getBean(Class<T> requiredType) {
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getBean(requiredType);
    }
}
