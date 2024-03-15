package cn.thatisme.blog.context.application.dto;

import cn.thatisme.blog.common.graphql.pageable.SearchContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2023/12/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CommentDto extends SearchContent {

    private Long id;

    private String content;

    private Long user;

    private Long article;

    private String ip;

    private boolean status;

    private Date createTime;

    private Date updatedTime;
}
