package com.gwachala.springapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.gwachala.springapp.model.Product;
import com.gwachala.springapp.service.ProductService;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

@EnableJpaAuditing
@SpringBootApplication(scanBasePackages={"com.gwachala.springapp"})
public class ShoppingCartApp{// extends SpringBootServletInitializer {

	 /*
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(ShoppingCartApp.class);
    }
   */ 
	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApp.class, args);
	}
	
	@Bean
    CommandLineRunner runner(ProductService productService) {
        return args -> {
            productService.save(new Product(1L, "TV", 1800.00, "FHD IPS"));
            productService.save(new Product(2L, "PC", 2000.00, "IPS"));
            productService.save(new Product(3L, "Notebook", 2600.00, "FHD"));
            productService.save(new Product(4L, "Phone", 500.00, "FHD"));
          
        };
}
}
