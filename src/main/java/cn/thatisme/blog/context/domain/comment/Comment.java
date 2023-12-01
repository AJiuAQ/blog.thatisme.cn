package cn.thatisme.blog.context.domain.comment;

import cn.thatisme.blog.common.domain.Entity;
import lombok.Data;

import java.util.Date;

/**
 * <p>评论</p>
 * @author wujinhang 2023/8/15
 */
@Data
public class Comment implements Entity<Comment> {

    private Long id;

    private CommentContent content;

    private Long user;

    private Long article;

    private IPAddress ip;

    private boolean status = true;

    private Date createTime;

    private Date updatedTime;
}
