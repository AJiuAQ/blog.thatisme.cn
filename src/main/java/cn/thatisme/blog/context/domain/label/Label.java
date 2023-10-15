package cn.thatisme.blog.context.domain.label;

import cn.thatisme.blog.common.domain.Entity;
import cn.thatisme.blog.common.domain.ID;
import lombok.Data;

/**
 * <p>标签</p>
 * @author wujinhang 2023/8/14
 */
@Data
public class Label implements Entity<Label> {

    private ID id;

    private LabelName name;
}
