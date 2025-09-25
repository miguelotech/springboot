package com.learning.springboot;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

//    @Bean
//    public OpenAPI customOpenAPI() {
//        return new OpenAPI()
//                .info();
//    }
// holamundo
}
