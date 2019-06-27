package com.harrywork.hotelhub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Harry
 * @date 19-6-25
 * Time: 17:36
 * Desc: SwaggerConfig
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerPlugin() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("Hotel Operate API Doc")
                .description("hotel booking system")
                .version("v0.0.1")
                .build();
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo)
                .useDefaultResponseMessages(false);
    }
}
