package com.shopezly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Shopezly", version = "2.0" , description = "Online Shopping Application") )
public class ShopezlyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopezlyApplication.class, args);
	}

}
