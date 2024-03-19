package cn.thatisme.blog.common.graphql.pageable;

import java.io.Serializable;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2023/11/29
 */
public abstract class SearchContent implements Serializable {
    public abstract String getGraphqlTypeName();
}
