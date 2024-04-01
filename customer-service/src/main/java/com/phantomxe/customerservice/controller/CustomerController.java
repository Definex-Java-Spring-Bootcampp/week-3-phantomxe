package com.phantomxe.customerservice.controller;

import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phantomxe.customerservice.dto.CustomerRequest;
import com.phantomxe.customerservice.entity.Customer;
import com.phantomxe.customerservice.services.CustomerService;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/{email}")
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email) {
        Customer customer = customerService.getCustomerbyEmail(email);

        if(customer != null) {
            return ResponseEntity.ok().body(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerRequest customerRequest) {
        Customer cs = customerService.addCustomer(customerRequest.getName(), customerRequest.getEmail(), customerRequest.getDateOfBirth());
        return ResponseEntity.status(HttpStatus.SC_CREATED).body(cs);
    }
}
