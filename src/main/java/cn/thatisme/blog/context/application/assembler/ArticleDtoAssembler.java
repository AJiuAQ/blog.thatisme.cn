//package cn.thatisme.blog.context.application.assembler;
//
//import cn.thatisme.blog.context.application.dto.ArticleDto;
//import cn.thatisme.blog.context.domain.article.Article;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.springframework.core.convert.converter.Converter;
//
///**
// * <p></p>
// * @author wujinhang 2023/8/17
// */
//@Mapper(componentModel = "spring")
//public interface ArticleDtoAssembler extends Converter<Article, ArticleDto> {
//
//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "title", source = "title.title")
//    @Mapping(target = "content", source = "content.content")
//    @Mapping(target = "auditor", source = "auditor")
//    @Mapping(target = "labels", source = "labels")
//    ArticleDto convert(Article article);
//}
