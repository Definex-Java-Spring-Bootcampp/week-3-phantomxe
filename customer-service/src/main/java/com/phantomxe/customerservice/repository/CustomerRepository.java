package com.phantomxe.customerservice.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.phantomxe.customerservice.entity.Customer;

public class CustomerRepository {
    private List<Customer> customers = new ArrayList<>();

    public CustomerRepository() {
        customers.addAll(List.of(
            new Customer("John", "test@test.com", LocalDate.of(1990, 10, 12)),
            new Customer("Cem", "test2@test.com", LocalDate.of(1997, 3, 3)),
            new Customer("Buse", "test3@test.com", LocalDate.of(1999, 9, 1)),
            new Customer("Ahmet", "test4@test.com", LocalDate.of(2000, 5, 13)),
            new Customer("Cem", "test5@test.com", LocalDate.of(2005, 7, 1))
        ));
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer addCustomer(Customer customer) {
        customers.add(customer);
        return customer;
    }

    public Optional<Customer> getCustomerByEmail(String email) {
        return customers.stream().filter(c -> c.getEmail().equals(email)).findFirst();
    }
}
