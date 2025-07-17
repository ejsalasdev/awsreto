package com.talentpool.retoaws.commons.openapi;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Person Microservice API",
        version = "v1.0.0",
        description = """
            **Person management microservice**

            This API allows you to create and consult persons with identification number, name, and email.
            Implements hexagonal architecture and DDD.

            ## Main features:
            - ✅ Save person (POST /api/v1/person)
            - ✅ Get person by identification number (GET /api/v1/person/{identificationNumber})
            - ✅ Robust business validations
            - ✅ Exception handling for not found and duplicate persons
            - ✅ H2 in-memory database for development
        """,
        license = @License(name = "MIT License", url = "https://opensource.org/licenses/MIT")
    ),
    servers = {
        @Server(description = "Local Development", url = "http://localhost:8191")
    }
)
public class OpenApiConfig {

}
