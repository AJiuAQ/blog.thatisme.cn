package cn.thatisme.blog.common.utils;

import org.springframework.core.convert.ConversionService;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * <p></p>
 * @author wujinhang 2023/8/19
 */
public class ConversionServiceUtils {
    private static final ConversionService conversionService = SpringContextHolder.getBean(ConversionService.class);

    public static <Source, Target> Target convert(Source source, Class<Target> targetType) {
        assert conversionService != null;
        return conversionService.convert(source, targetType);
    }

    public static <Source, Target> List<Target> convertBatch(Spliterator<Source> source, Class<Target> targetType) {
        assert conversionService != null;
        assert source != null;
        return StreamSupport.stream(source, false).map(e -> conversionService.convert(e, targetType)).collect(Collectors.toList());
    }
}
