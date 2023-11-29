package cn.thatisme.blog.common.graphql.pageable;

import lombok.Data;

import java.io.Serializable;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2023/11/29
 */
@Data
public class Query implements Serializable {

    public PageInfo pageInfo;

    public Query(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
