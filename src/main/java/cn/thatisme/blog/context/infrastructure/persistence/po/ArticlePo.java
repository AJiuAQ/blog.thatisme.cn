package cn.thatisme.blog.context.infrastructure.persistence.po;

import cn.thatisme.blog.common.persistence.BasePo;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.util.Date;
import java.util.List;

/**
 * <p></p>
 * @author wujinhang 2023/10/11
 */@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "article")
@Comment("文章表")
public class ArticlePo extends BasePo {

    @Column(nullable = false, unique = true)
    @Comment("标题")
    private String title;

    @Lob
    @Column(nullable = false, columnDefinition = "longtext")
    @Comment("正文")
    private String content;

    @ManyToMany
    @JoinTable(name = "article_label", joinColumns = { @JoinColumn(name = "article_id")},
            inverseJoinColumns = { @JoinColumn(name = "label_id")}
    )
    @Comment("标签")
    private List<LabelPo> labels;

    @Column(nullable = false)
    @Comment("是否置顶， 0-否 | 1-是")
    private Boolean topping = false;

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
