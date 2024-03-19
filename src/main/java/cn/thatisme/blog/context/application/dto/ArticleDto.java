package cn.thatisme.blog.context.application.dto;

import cn.thatisme.blog.common.graphql.pageable.SearchContent;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2023/12/13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ArticleDto extends SearchContent {

    /**
     * id
     */
    private Long id;

    private String title;

    private String content;

    private List<LabelDto> labels;

    private boolean topping;

    private boolean status;

    private Date createTime;

    private Date updateTime;

    @Override
    public String getGraphqlTypeName() {
        return "Article";
    }
}
