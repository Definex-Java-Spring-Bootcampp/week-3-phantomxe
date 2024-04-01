package com.phantomxe.invoiceservice.entity;

import com.phantomxe.invoiceservice.enums.ProductCategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    private String name;
    private Double price;
    private Integer quantity;
    private ProductCategory category;
}
