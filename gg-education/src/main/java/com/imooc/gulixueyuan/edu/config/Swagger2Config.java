package com.imooc.gulixueyuan.edu.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author helen
 * @since 2018/12/18
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket webApiConfig(){

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())//调用一个自定义的apiInfo方法，生成swagger文档的基本描述
                .select() //创建ApiSelectorBuilder对象
                .paths(Predicates.not(PathSelectors.regex("/admin/.*"))) //过滤掉admin接口
                .paths(Predicates.not(PathSelectors.regex("/error.*"))) //过滤掉error接口
                .build();
    }

    private ApiInfo webApiInfo() {

        return new ApiInfoBuilder()
                .title("课程管理前台网站的微服务API")//文档标题
                .description("此文档描述了课程管理前台网站的基本API接口")
                .version("1.0")//版本
                .contact(new Contact("Helen", "http://atguigu.com", "55317332@qq.com"))//作者
                .build();
    }

    @Bean
    public Docket adminApiConfig(){

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("adminApi")
                .apiInfo(adminApiInfo())//调用一个自定义的apiInfo方法，生成swagger文档的基本描述
                .select() //创建ApiSelectorBuilder对象
                .paths(Predicates.and(PathSelectors.regex("/admin/.*"))) //过滤掉admin接口
                .build();
    }

    private ApiInfo adminApiInfo() {

        return new ApiInfoBuilder()
                .title("课程管理后台管理系统的微服务API")//文档标题
                .description("此文档描述了课程管理后台管理系统的基本API接口")
                .version("1.0")//版本
                .contact(new Contact("Helen", "http://atguigu.com", "55317332@qq.com"))//作者
                .build();
    }
}
