package com.eureka.liveAndMove.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eureka.liveAndMove.Repository.ProductRepository;
import com.eureka.liveAndMove.dto.ProductDto;



@Service
public class ProductService {

	
	 private final ProductRepository productRepository;

	    public ProductService(ProductRepository productRepository) {
	        this.productRepository = productRepository;
	    }
	    
	    public List<ProductDto> findAll() {
	        return productRepository.findAll();
	    }

	    public ProductDto findById(String product_id) {
	        return productRepository.findById(product_id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
	    }
}
