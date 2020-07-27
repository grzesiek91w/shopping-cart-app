package com.gwachala.springapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.gwachala.springapp.model.Product;
import com.gwachala.springapp.service.ProductService;



@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = { "", "/" })
    public  Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@PathVariable long id) {
		Product product = productService.getProduct(id);

		if (product != null) {
			return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
    
    @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
		Product currentProduct = productService.getProduct(id);
		
		if (currentProduct.getId() == id) {
			productService.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	 @PutMapping("/{id}")
	 public ResponseEntity<?> replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {
		 
		 Product currentProduct = productService.getProduct(id);
		 if(currentProduct!=null) {
			 currentProduct.setName(newProduct.getName());
			 currentProduct.setDescription(newProduct.getDescription());
			 currentProduct.setPrice(newProduct.getPrice());	 
			 return new ResponseEntity<>(productService.save(currentProduct),HttpStatus.OK);
		 }
		 else{
			 newProduct.setId(id);
			 return new ResponseEntity<>(productService.save(newProduct),HttpStatus.OK);
		 }

	  }
    
    
}
