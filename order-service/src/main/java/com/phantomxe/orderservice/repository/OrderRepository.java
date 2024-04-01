package com.phantomxe.orderservice.repository;

import java.util.ArrayList;
import java.util.List;

import com.phantomxe.orderservice.entity.Order;

public class OrderRepository {
    private List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
