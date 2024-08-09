package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration

public class SpringFoxConfig {
    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info().title("Demo API")
                .description("This is a demo API for Spring Boot")
                .version("1.0")
                        .license(new io.swagger.v3.oas.models.info.License().name("Apache 2.0").url("http://springdoc.org")
                        ));

    }
}
