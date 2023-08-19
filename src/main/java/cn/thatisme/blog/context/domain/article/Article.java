package cn.thatisme.blog.context.domain.article;

import cn.thatisme.blog.common.domain.Entity;
import cn.thatisme.blog.common.domain.ID;
import cn.thatisme.blog.context.domain.label.LabelName;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * <p>文章</p>
 * @author wujinhang 2023/8/14
 */
@Data
public class Article implements Entity<Article> {

    private ID id;

    private Title title;

    private ArticleContent content;

    private ID auditor;

    private List<LabelName> labels;

    private boolean topping = false;

    private boolean status = true;

    private Date createTime;

    private Date updateTime;
}
