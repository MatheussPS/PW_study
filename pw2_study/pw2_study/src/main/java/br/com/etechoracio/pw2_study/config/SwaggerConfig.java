package br.com.etechoracio.pw2_study.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().
                info(new Info().
                        title("PW Study - Rest API")
                        .description("Rest API da aplicação PW Study da ETEC")
                        .version("1.0"))
                .externalDocs(
                        new ExternalDocumentation()
                                .description("ETEC Horácio Augusto da Silveira")
                                .url("https://etechoracio.com.br/has/"));

    }

}
