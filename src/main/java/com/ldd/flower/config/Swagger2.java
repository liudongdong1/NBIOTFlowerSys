package com.ldd.flower.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author liudongdong
 * @Date Created in 8:59 2019/9/20
 * @Description
 */
@Configuration     //让Spring来加载该类配置
@EnableSwagger2    //注解来启用Swagger2。
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ldd"))  //注意这里路径
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("花卉培育管理系统API")
                .description("更多Spring Boot相关文章请关注：https://blog.csdn.net/liudongdong19")
                .termsOfServiceUrl("https://blog.csdn.net/liudongdong19/")
                .contact("liudongdong")
                .version("1.0")
                .build();
    }

}
