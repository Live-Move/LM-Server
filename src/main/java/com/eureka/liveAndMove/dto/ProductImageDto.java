package com.eureka.liveAndMove.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@IdClass(ProductImageDtoId.class)  // 복합 키 클래스 지정
@Table(name = "product_img")
public class ProductImageDto {

    @Id
    private int img_id;  // 복합 키의 일부

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")  // 외래 키 설정
    private ProductDto product;  // 복합 키의 일부 및 외래 키

    private String img_path;  // 이미지 경로
}

	