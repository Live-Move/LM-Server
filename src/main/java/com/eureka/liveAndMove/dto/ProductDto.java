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
	private int product_id;
	private String product_name, sub_product_name, brand, description, detail;
	private int price;
}
