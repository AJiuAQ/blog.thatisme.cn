package cn.thatisme.blog.context.application.query;

import cn.thatisme.blog.common.annotation.Query;
import cn.thatisme.blog.common.graphql.pageable.PageQuery;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2023/12/13
 */
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
public class LabelQuery extends PageQuery {

    @Query
    private Long id;

    @Query(type = Query.Type.RIGHT_LIKE)
    private String name;

    @Query(blurry = "content")
    private String blurry;

}
