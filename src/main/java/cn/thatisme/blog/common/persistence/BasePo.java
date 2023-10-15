package cn.thatisme.blog.common.persistence;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

/**
 * <p></p>
 * @author wujinhang 2023/8/4
 */
@MappedSuperclass
@Getter
@Setter
public class BasePo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SnowflakeGenerator")
    @GenericGenerator(name = "SnowflakeGenerator", type = SnowflakeGenerator.class)
    @Comment("id")
    private Long id;
}
