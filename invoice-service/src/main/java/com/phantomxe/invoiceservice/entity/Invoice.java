package com.phantomxe.invoiceservice.entity;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Invoice { 
    private Integer invoiceNumber;
    private List<Product> products;
    private Customer customer;
    private LocalDate date = LocalDate.now();
    private Double totalPrice;

    public Invoice(Integer invoiceNumber, List<Product> products, Customer customer) {
        this.invoiceNumber = invoiceNumber;
        this.products = products;
        this.customer = customer; 
        this.totalPrice = products.stream()
            .mapToDouble(product -> {
                return product.getPrice() * product.getQuantity();
            })
            .sum();;
    }
}
