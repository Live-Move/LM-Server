package com.eureka.liveAndMove.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eureka.liveAndMove.dto.ProductDto;
import com.eureka.liveAndMove.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	
	private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable String product_id) {
        return ResponseEntity.ok(productService.findById(product_id));
    }
}
