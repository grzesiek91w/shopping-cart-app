package com.gwachala.springapp.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.gwachala.springapp.model.Product;
import com.gwachala.springapp.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product  getProduct(long id) {
        return productRepository
          .findOne(id);
          //.orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

	@Override
	public void delete(long id) {
		productRepository.delete(id);
		
	}
	 @Override
	    public void update(Product product) {
	        this.productRepository.save(product);
	    }
}