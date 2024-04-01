package com.phantomxe.orderservice.client.dto;

import java.util.List;

import com.phantomxe.orderservice.entity.Customer;
import com.phantomxe.orderservice.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class InvoiceRequest {
    private Customer customer;
    private List<Product> products;
}
