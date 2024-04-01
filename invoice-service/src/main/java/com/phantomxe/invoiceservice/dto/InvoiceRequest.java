package com.phantomxe.invoiceservice.dto;

import java.util.List;

import com.phantomxe.invoiceservice.entity.Customer;
import com.phantomxe.invoiceservice.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InvoiceRequest {
    private Customer customer;
    private List<Product> products;
}
