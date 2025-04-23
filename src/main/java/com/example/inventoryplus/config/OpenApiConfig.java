package com.example.inventoryplus.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(title = "API de Inventario Plus", version = "1.0", description = "API para gestionar inventarios y productos.")
)
@Configuration
public class OpenApiConfig {
}
