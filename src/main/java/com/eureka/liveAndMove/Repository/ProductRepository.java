package com.eureka.liveAndMove.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eureka.liveAndMove.dto.ProductDto;

public interface ProductRepository extends JpaRepository<ProductDto, String>{

	// 검색어를 포함한 상품을 찾아주는 메서드
	List<ProductDto> findByProductNameContaining(String name);
	
	// 특정 카테고리를 포함한 상품을 찾아주는 메서드
	List<ProductDto> findByCategoryContaining(String category);
	
}
