package cn.thatisme.blog.common.mapstruct;

import cn.thatisme.blog.common.domain.ValueObject;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2024/3/5
 */
@Component
public class ValueObjectStrategy {

    public <T extends ValueObject<T>> String valueObjectToString(T value) {
        if (value instanceof Record) {
            Field[] fields = value.getClass().getDeclaredFields();
            if (fields.length == 0) {
                return null;
            } else {
                boolean accessible = fields[0].canAccess(value);
                // 设置对象的访问权限，保证对private的属性的访
                fields[0].setAccessible(true);
                try {
                    return fields[0].get(value).toString();
                } catch (IllegalAccessException e) {
                    fields[0].setAccessible(accessible);
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }

    public <T extends ValueObject<T>> T valueObjectToString(String value, @TargetType Class<T> entityClass) {
        try {
            return value != null ? entityClass.getDeclaredConstructor(String.class).newInstance(value) : null;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            return null;
        }
    }
}
