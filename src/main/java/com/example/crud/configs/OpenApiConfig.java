package com.example.crud.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title="Servicios Crud",
                version = "1.0.0",
                description = "This is a Crud for management"
        )

)
public class OpenApiConfig {

}
