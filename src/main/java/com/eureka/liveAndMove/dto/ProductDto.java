package com.eureka.liveAndMove.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="product")
public class ProductDto {
	@Id
	private String product_id;
	private String product_name, category, brand, description, detail;
	private int price;
}
