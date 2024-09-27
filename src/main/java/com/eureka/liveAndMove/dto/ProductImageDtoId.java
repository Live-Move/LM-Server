package com.eureka.liveAndMove.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class ProductImageDtoId implements Serializable {
    private String product;  // product_id
    private int img_id;      // 이미지 ID

    // 기본 생성자
    public ProductImageDtoId() {}

    // 생성자
    public ProductImageDtoId(String product_id, int img_id) {
        this.product = product_id;
        this.img_id = img_id;
    }

}

