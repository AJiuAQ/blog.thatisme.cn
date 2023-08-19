package cn.thatisme.blog.common.utils;

import org.springframework.core.convert.ConversionService;
import org.springframework.lang.Nullable;

/**
 * <p></p>
 * @author wujinhang 2023/8/19
 */
public class ConversionServiceUtils {
    private static final ConversionService conversionService = SpringContextHolder.getBean(ConversionService.class);

    public static <T> T convert(@Nullable Object source, Class<T> targetType) {
        assert conversionService != null;
        return conversionService.convert(source, targetType);
    }
}
