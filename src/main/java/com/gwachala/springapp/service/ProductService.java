package com.gwachala.springapp.service;

import org.springframework.validation.annotation.Validated;

import com.gwachala.springapp.model.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface ProductService {

    @NotNull Iterable<Product> getAllProducts();

    Product getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

    Product save(Product product);
    
    void delete(long id);

	void update(Product product);
}
