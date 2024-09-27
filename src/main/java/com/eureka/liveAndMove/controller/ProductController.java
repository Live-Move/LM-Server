package com.eureka.liveAndMove.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.liveAndMove.dto.ProductDto;
import com.eureka.liveAndMove.service.ProductService;

@RestController
@CrossOrigin(origins="*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	// Spring 연결 확인 <확인>
	@GetMapping("/product/connection")
	public String checkConnection() {
		return "[ Connected ] product controller";
	}
	
	// 검색한 값 읽기
	@GetMapping("/api/product/search")
	public List<ProductDto> searchProducts(@RequestParam("name") String name){
		return productService.searchProductsByName(name);
	}
	
	// listPage 상품 목록 카테고리 기준으로 읽어 오기
	@GetMapping("/api/product/list")
	public List<ProductDto> productsListByCateogry(@RequestParam("category") String category){
		return productService.productsListByCategory(category);
	}
}