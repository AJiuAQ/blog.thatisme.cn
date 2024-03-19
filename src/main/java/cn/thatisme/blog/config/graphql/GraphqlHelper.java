package cn.thatisme.blog.config.graphql;

import cn.thatisme.blog.common.graphql.pageable.SearchContent;
import lombok.Getter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <p></p>
 * @author wujinhang me@thatisme.cn 2023/11/30
 */
public class GraphqlHelper implements ApplicationRunner {

    @Getter
    private static final Map<Class<?>, String> typeMap = new HashMap<>();


    public static void addGraphqlType(Class<?> clazz, String typeName) {
        typeMap.put(clazz, typeName);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AssignableTypeFilter(SearchContent.class));

        Set<BeanDefinition> components = provider.findCandidateComponents("cn/thatisme");
        for (BeanDefinition component : components) {
            Class<?> cls = Class.forName(component.getBeanClassName());

            Object o = cls.getDeclaredConstructor().newInstance();
            if (o instanceof SearchContent) {
                addGraphqlType(cls, ((SearchContent) o).getGraphqlTypeName());
            }
        }
    }
}
