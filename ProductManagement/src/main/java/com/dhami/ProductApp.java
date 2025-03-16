package com.dhami;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(

		info = @Info(
				title = "Product Service API Documention",
				description = "product service ",
				version = "1",
				contact = @Contact(
						name = "Pankaj Singh Dhami",
						email = "pankajdhami811@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "sharepoint URL product service API",
				url = "example.com"
		)

)
@SpringBootApplication
public class ProductApp {

	public static void main(String[] args) {
		SpringApplication.run(ProductApp.class, args);
	}

}
