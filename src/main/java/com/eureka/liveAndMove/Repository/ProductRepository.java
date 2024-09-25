package com.eureka.liveAndMove.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eureka.liveAndMove.dto.ProductDto;

public interface ProductRepository extends JpaRepository<ProductDto, Integer>{

}
