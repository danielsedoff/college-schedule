package com.danielsedoff.college.schedule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
    @Bean
    public Docket coursesApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.danielsedoff.college.schedule.controller"))
<<<<<<< HEAD
                .paths(PathSelectors.regex("/.*")).build().apiInfo(metaData());
=======
                .paths(PathSelectors.regex("/courses.*")).build().apiInfo(metaData());
>>>>>>> 5cb4dd70e357c35f7279ce683907bd8aa9671e4c
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder().title("Spring Boot REST API")
                .description("\"Spring Boot REST API for the College Schedule Web App\"").version("0.1")
<<<<<<< HEAD
                .license("GNU GPL 2.0").licenseUrl("https://www.gnu.org/licenses/old-licenses/gpl-2.0.html")
                .contact(new Contact("Daniel Sedoff", "https://github.com/danielsedoff", "sedoff@zohomail.com"))
=======
                .license("GNU GPL 1.0").licenseUrl("https://www.gnu.org/licenses/old-licenses/gpl-2.0.html")
                .contact(
                        new Contact("Daniel Sedoff", "https://github.com/danielsedoff", "sedoff@zohomail.com"))
>>>>>>> 5cb4dd70e357c35f7279ce683907bd8aa9671e4c
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}