package cn.thatisme.blog.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2023/12/13
 */
@Data
@AllArgsConstructor
public class EntityConversion {

    private Class<?> dto;

    private Class<?> entity;

    private Class<?> po;

    private Class<?> command;
}
