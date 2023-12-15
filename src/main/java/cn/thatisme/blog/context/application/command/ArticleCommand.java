package cn.thatisme.blog.context.application.command;

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

    private String title;

    private String content;

    private Long auditor;

    private Boolean topping;

    private Boolean status;
}
