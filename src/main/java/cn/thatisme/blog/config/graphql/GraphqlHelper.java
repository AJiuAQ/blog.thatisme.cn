package cn.thatisme.blog.config.graphql;

import cn.thatisme.blog.context.application.dto.ArticleDto;
import cn.thatisme.blog.context.application.dto.CommentDto;
import cn.thatisme.blog.context.application.dto.LabelDto;
import cn.thatisme.blog.context.application.dto.UserDto;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2023/11/30
 */
public class GraphqlHelper {

    @Getter
    private static final Map<Class<?>, String> typeMap = new HashMap<>();

    static {
        typeMap.put(UserDto.class, "User");
        typeMap.put(ArticleDto.class, "Article");
        typeMap.put(LabelDto.class, "Label");
        typeMap.put(CommentDto.class, "Comment");
    }

}
