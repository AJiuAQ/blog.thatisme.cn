package cn.thatisme.blog.common.domain;

import cn.hutool.core.util.ObjectUtil;

/**
 * <p>ID</p>
 * @author wujinhang 2023/4/17
 */
public record ID(Long id) implements ValueObject<ID> {

    public ID {
        if (ObjectUtil.isEmpty(id)) {
            throw new IllegalArgumentException("id 不能为空");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
