package cn.thatisme.blog.context.infrastructure.persistence.po;

import cn.thatisme.blog.common.persistence.BasePo;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.util.Date;

/**
 * <p></p>
 * @author wujinhang 2023/10/11
 */@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "comment")
@Comment("评论表")
public class CommentPo extends BasePo {

    @Column(length = 500, nullable = false)
    @Comment("正文")
    private String content;

    @ManyToOne
    @Comment("用户")
    private UserPo user;

    @ManyToOne
    @Comment("文章")
    private ArticlePo article;

    @Comment("ip地址")
    private String ip;

    @Column(nullable = false)
    @Comment("是否启用， 0-否 | 1-是")
    private Boolean status = false;

    @Column
    @Comment("创建时间")
    private Date createdTime;

    @Column
    @Comment("更新时间")
    private Date updatedTime;
}
