package cn.thatisme.blog.context.application.query;

import cn.thatisme.blog.common.graphql.pageable.PageInfo;
import cn.thatisme.blog.common.graphql.pageable.Query;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2023/11/29
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class UserQuery extends Query {
    private String username;
    private String email;
    private String admin;

    public UserQuery(String username, String email, String admin, PageInfo pageInfo) {
        super(pageInfo);
        this.username = username;
        this.email = email;
        this.admin = admin;
    }

}
