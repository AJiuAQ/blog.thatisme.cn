package cn.thatisme.blog.common.mapstruct;

import cn.thatisme.blog.common.domain.ValueObject;
import cn.thatisme.blog.common.persistence.BasePo;
import org.jetbrains.annotations.Nullable;
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

    /**
     * 值对象到 string
     * @param value 值对象
     * @param <T> ValueObject<T>
     * @return string
     */
    public <T extends ValueObject<T>> String valueObjectToString(T value) {
        return (String) getValue(value);
    }

    /**
     * 值对象到 boolean
     * @param value 值对象
     * @param <T> ValueObject<T>
     * @return boolean
     */
    public <T extends ValueObject<T>> Boolean valueObjectToBoolean(T value) {
        return (Boolean) getValue(value);
    }

    /**
     * 值对象到 int
     * @param value 值对象
     * @param <T> ValueObject<T>
     * @return int
     */
    public <T extends ValueObject<T>> Integer valueObjectToInteger(T value) {
        return (Integer) getValue(value);
    }

    /**
     * 从值对象取值
     * @param value 值对象
     * @param <T> ValueObject<T>
     * @return 值
     */
    private static <T extends ValueObject<T>> Object getValue(T value) {
        if (value instanceof Record) {
            Field[] fields = value.getClass().getDeclaredFields();
            if (fields.length == 0) {
                return null;
            } else {
                boolean accessible = fields[0].canAccess(value);
                // 设置对象的访问权限，保证对private的属性的访
                fields[0].setAccessible(true);
                try {
                    return fields[0].get(value);
                } catch (IllegalAccessException e) {
                    fields[0].setAccessible(accessible);
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }

    /**
     * string 到值对象
     * @param value string
     * @param entityClass 值对象.class
     * @param <T> ValueObject<T>
     * @return 值对象
     */
    public <T extends ValueObject<T>> T toValueObject(String value, @TargetType Class<T> entityClass) {
        return getValue(value, entityClass);
    }

    /**
     * boolean 到值对象
     * @param value boolean
     * @param entityClass 值对象.class
     * @param <T> ValueObject<T>
     * @return 值对象
     */
    public <T extends ValueObject<T>> T toValueObject(Boolean value, @TargetType Class<T> entityClass) {
        return getValue(value, entityClass);
    }

    /**
     * int 到值对象
     * @param value int
     * @param entityClass 值对象.class
     * @param <T> ValueObject<T>
     * @return 值对象
     */
    public <T extends ValueObject<T>> T toValueObject(Integer value, @TargetType Class<T> entityClass) {
        return getValue(value, entityClass);
    }

    /**
     * 从值到值对象
     * @param value 值
     * @param entityClass 值对象.class
     * @param <T> ValueObject<T>
     * @return 值对象
     */
    @Nullable
    private static <T extends ValueObject<T>> T getValue(Object value, Class<T> entityClass) {
        try {
            return value != null ? entityClass.getDeclaredConstructor(value.getClass()).newInstance(value) : null;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            return null;
        }
    }

    /**
     * po 到 long
     * @param value po
     * @param <T> BasePo
     * @return long
     */
    public <T extends BasePo> Long poToLong(T value) {
        return value.getId();
    }

    /**
     * long 到 po
     * @param value long
     * @param entityClass po
     * @param <T> BasePo
     * @return po
     */
    public <T extends BasePo> T longToPo(Long value, @TargetType Class<T> entityClass) {
        try {
            if (value == null) {
                return null;
            }
            T t = entityClass.getDeclaredConstructor().newInstance();
            t.setId(value);
            return t;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            return null;
        }
    }

}
