package com.eureka.liveAndMove.dto;

import jakarta.persistence.Column;
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

    @Column(name = "product_name")
    private String productName;

    private String category, brand, description, detail;
    private int price;

}


