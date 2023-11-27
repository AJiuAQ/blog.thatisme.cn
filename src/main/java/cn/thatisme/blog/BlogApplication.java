package cn.thatisme.blog;

import cn.thatisme.blog.common.utils.EnvFileUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <p>启动类</p>
 * @author wujinhang 2023/4/15
 */
@SpringBootApplication
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplicationBuilder applicationBuilder = new SpringApplicationBuilder(BlogApplication.class);
        applicationBuilder.properties(EnvFileUtils.getProperties());
        applicationBuilder.run(args);
    }
}
