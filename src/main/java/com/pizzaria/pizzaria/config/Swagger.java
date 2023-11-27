package com.pizzaria.pizzaria.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {

    @Bean
    public OpenAPI openAPI(){

        return new OpenAPI()
                .info(new Info()
                        .title("Pizzaria API")
                        .description("Projeto de uma API Java+SpringBoot, para Restaurantes e Pizzarias")
                        .version("1.0.0")
                        .contact(contact())
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://springdoc.org")));
    }

    public Contact contact(){
        Contact contact = new Contact();

        contact.setName("Emilio Anastacio de Paula Correa");
        contact.setUrl("https://github.com/EmilioAnastacio");
        contact.setEmail("emilioanastacio@gmail.com");

        return contact;
    }
}