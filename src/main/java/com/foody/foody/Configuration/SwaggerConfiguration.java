package com.foody.foody.Configuration;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Component;

@Component
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "FoodyApi",
                        email = ""

                ),
                description = "Open Api documentation for FoodyApi",
                title = "OpenApi FoodyApi",
                version = "1.0"
        )
        , servers = {
        @Server(
                description = "Production ENV",
                url = "https://profitable-lonee-rojpos-3f8a4c13.koyeb.app/"
        ),
        @Server(
                description = "Local ENV",
//            url = "http://localhost:8082"
//                url = "http://192.168.246.132:8082"
                url = "http://10.216.242.132:8082"
        )

}, security = {
        @SecurityRequirement(name = "bearerAuth")
}
)
@SecurityScheme(
        name = "bearerAuth",
        description = "Jwt Auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class SwaggerConfiguration {
}
