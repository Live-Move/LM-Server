package com.eureka.liveAndMove.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eureka.liveAndMove.Repository.ProductRepository;
import com.eureka.liveAndMove.dto.ProductDto;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	// 검색 서비스
	public List<ProductDto> searchProductsByName(String name){
		return productRepo.findByProductNameContaining(name);
	}
	
	// 페이지 리스트 서비스
	public List<ProductDto> productsListByCategory(String category){
		return productRepo.findByCategoryContaining(category);
	}
}