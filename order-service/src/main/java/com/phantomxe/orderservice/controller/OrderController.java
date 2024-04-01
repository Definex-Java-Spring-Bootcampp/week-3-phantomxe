package com.phantomxe.orderservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phantomxe.orderservice.dto.OrderAddProductRequest;
import com.phantomxe.orderservice.entity.Customer;
import com.phantomxe.orderservice.entity.Order;
import com.phantomxe.orderservice.entity.Product;
import com.phantomxe.orderservice.service.CustomerService;
import com.phantomxe.orderservice.service.OrderService;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/create")
    public Integer createOrder() {
        return orderService.createOrder();
    }

    @GetMapping("/buffer")
    public Map<Integer, Order> getBufferedOrders() {
        return orderService.getBufferedOrders();
    } 

    @PostMapping("/buffer/{orderId}/addProduct")
    public Order addProductToOrder(@PathVariable Integer orderId, @RequestBody OrderAddProductRequest req) {
        return orderService.addProductToOrder(orderId, req.getProductName(), req.getQuantity());
    }

    @GetMapping("/buffer/{orderId}/complete/{email}")
    public void confirmOrder(@PathVariable Integer orderId, @PathVariable String email) {
        Customer customer = customerService.getCustomerByEmail(email);
        orderService.completeOrder(orderId, customer);
    }
}
