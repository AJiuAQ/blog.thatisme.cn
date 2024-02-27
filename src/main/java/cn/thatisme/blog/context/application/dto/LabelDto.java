package cn.thatisme.blog.context.application.dto;

import cn.thatisme.blog.common.graphql.pageable.SearchContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2023/12/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class LabelDto extends SearchContent {

    /**
     * id
     */
    private Long id;

    private String name;
}
