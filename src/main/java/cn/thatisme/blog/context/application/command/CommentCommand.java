package cn.thatisme.blog.context.application.command;

import lombok.Data;

import java.util.Date;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2023/12/13
 */
@Data
public class CommentCommand {

    private Long id;

    private String content;

    private Long user;

    private Long article;

    private String ip;

    private boolean status;

    private Date createTime;

    private Date updatedTime;
}
