package cn.thatisme.blog.context.application.command;

import cn.thatisme.blog.context.domain.article.Title;
import lombok.Data;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2023/12/13
 */
@Data
public class ArticleCommand {

    /**
     * id
     */
    private Long id;

    private Title title;

    private String content;

    private Long auditor;

    private boolean topping;

    private boolean status;
}
