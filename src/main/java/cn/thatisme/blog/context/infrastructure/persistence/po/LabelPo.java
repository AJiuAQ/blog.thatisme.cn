package cn.thatisme.blog.context.infrastructure.persistence.po;

import cn.thatisme.blog.common.persistence.BasePo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

/**
 * <p></p>
 * @author wujinhang 2023/10/11
 */@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "label")
@Comment("标签表")
public class LabelPo extends BasePo {

    @Column(length = 64, nullable = false, unique = true)
    @Comment("标签名")
    private String labelName;
}
