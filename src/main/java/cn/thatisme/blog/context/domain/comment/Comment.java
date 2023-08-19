package cn.thatisme.blog.context.domain.comment;

import cn.thatisme.blog.common.domain.Entity;
import cn.thatisme.blog.common.domain.ID;
import lombok.Data;

import java.util.Date;

/**
 * <p>评论</p>
 * @author wujinhang 2023/8/15
 */
@Data
public class Comment implements Entity<Comment> {

    private ID id;

    private ID user;

    private ID article;

    private IPAddress ip;

    private CommentContent content;

    private Date createTime;

    private boolean status = true;
}
