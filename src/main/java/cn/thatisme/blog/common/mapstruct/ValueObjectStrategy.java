package cn.thatisme.blog.common.mapstruct;

import cn.thatisme.blog.common.domain.ValueObject;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2024/3/5
 */
@Component
public class ValueObjectStrategy {

    public <T extends ValueObject<T>> String valueObjectToString(T value) {
        if (value instanceof Record) {
            Field[] fields = value.getClass().getFields();
            if (fields.length == 0) {
                return null;
            } else if (fields.length > 1) {
                try {
                    Object result = fields[0].get(value);
                    return result.toString();
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }

}
