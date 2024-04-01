package com.phantomxe.orderservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; 

import com.phantomxe.orderservice.entity.Customer;

@FeignClient("customer-service")
public interface CustomerServiceClient {

    @GetMapping("api/customers")
    public List<Customer> getCustomers();

    @GetMapping("api/customers/{email}")
    public Customer getCustomerByEmail(@PathVariable String email);
}
