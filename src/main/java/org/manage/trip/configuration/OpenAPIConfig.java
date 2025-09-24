package org.manage.trip.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.Servers;

@OpenAPIDefinition(
        info = @Info(
                description = "Trip Project API Documentation",
                license = @License(
                        name = "1L"
                ),
                version = "1.0",
                termsOfService = "Terms Of Service",
                contact = @Contact(
                        name = "Henry Tech",
                        email = "fakorodehenry@gmail.com"
                )
        ),
        servers = {
                @Server(
                        description = "Local Development",
                        url = "http://localhost:8080/"
                )
        }
)
public class OpenAPIConfig {
}
