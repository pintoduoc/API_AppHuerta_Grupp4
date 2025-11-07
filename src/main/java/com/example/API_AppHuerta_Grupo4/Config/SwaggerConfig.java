package com.example.API_AppHuerta_Grupo4.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API App Huerta Grupo 4")
                        .version("1.0")
                        .description("Esta api es para la app del ramo Desarrollo de Apps Moviles 002D"));
    }
}
