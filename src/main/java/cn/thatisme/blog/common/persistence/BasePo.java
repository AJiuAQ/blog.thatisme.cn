package cn.thatisme.blog.common.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.Date;

/**
 * <p></p>
 * @author wujinhang 2023/8/4
 */
@MappedSuperclass
public class BasePo {

    @Id
    private Long id;

    /**
     * 创建人
     */
    @Column
    private String createdBy;

    /**
     * 创建时间
     */
    @Column
    private Date createdTime;

    /**
     * 更新人
     */
    @Column
    private String updatedBy;

    /**
     * 更新时间
     */
    @Column
    private Date updatedTime;
}
