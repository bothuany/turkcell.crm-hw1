package com.turkcell.crm_hw1.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Turkcell CRM API")
                        .version("1.0")
                        .description("Turkcell CRM Homework 1 API Documentation")
                        .contact(new Contact()
                                .name("Turkcell")
                                .email("contact@turkcell.com.tr")));
    }
} 