package com.phantomxe.customerservice.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.phantomxe.customerservice.entity.Customer;
import com.phantomxe.customerservice.repository.CustomerRepository;

@Service
public class CustomerService {
    
    private CustomerRepository customerRepository = new CustomerRepository();

    public Customer addCustomer(String name, String email, LocalDate dateOfBirth) {
        return customerRepository.addCustomer( new Customer( name, email, dateOfBirth) );
    }

    public Customer getCustomerbyEmail(String email) {
        Optional<Customer> customer = customerRepository.getCustomerByEmail(email);

        if(customer.isPresent()) {
            return customer.get();
        } else {
            return null;
        }
    }

    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }


}
