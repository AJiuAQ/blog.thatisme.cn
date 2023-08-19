package cn.thatisme.blog.context.domain.label;

import cn.thatisme.blog.common.domain.ValueObject;
import lombok.NonNull;

/**
 * <p>标签名称</p>
 * @author wujinhang 2023/8/14
 */
public record LabelName(@NonNull String name) implements ValueObject<LabelName> {
}
