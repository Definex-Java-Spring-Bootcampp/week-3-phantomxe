package com.phantomxe.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderAddProductRequest {
    private String productName;
    private Integer quantity;
}
