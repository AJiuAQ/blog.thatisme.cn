package cn.thatisme.blog.context.application.query;

import cn.thatisme.blog.common.annotation.Query;
import cn.thatisme.blog.common.graphql.pageable.PageQuery;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2023/11/29
 */
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
public class UserQuery extends PageQuery {

    @Query
    private Long id;

    @Query(type = Query.Type.RIGHT_LIKE)
    private String username;

    @Query(blurry = "username,email")
    private String blurry;

    @Query
    private Boolean admin;

}
