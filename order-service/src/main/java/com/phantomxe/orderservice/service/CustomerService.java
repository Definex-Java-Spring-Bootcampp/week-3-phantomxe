package com.phantomxe.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phantomxe.orderservice.client.CustomerServiceClient;
import com.phantomxe.orderservice.entity.Customer;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerServiceClient customerServiceClient;

    public Customer getCustomerByEmail(String email) {
        return customerServiceClient.getCustomerByEmail(email);
    }

}
