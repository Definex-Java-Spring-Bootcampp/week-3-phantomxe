package com.phantomxe.orderservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phantomxe.orderservice.client.InvoiceServiceClient;
import com.phantomxe.orderservice.client.dto.InvoiceRequest;
import com.phantomxe.orderservice.client.dto.InvoiceResponse;
import com.phantomxe.orderservice.entity.Customer;
import com.phantomxe.orderservice.entity.Order;
import com.phantomxe.orderservice.entity.Product;
import com.phantomxe.orderservice.exceptions.OrderException;
import com.phantomxe.orderservice.repository.OrderRepository;
import com.phantomxe.orderservice.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private InvoiceServiceClient invoiceServiceClient;

    private OrderRepository orderRepository = new OrderRepository();
    private ProductRepository productRepository = new ProductRepository();
    private Map<Integer, Order> ordersBuffer = new HashMap<>();
    private Integer orderId = 0;

    public List<Order> getOrders() {
        return orderRepository.getOrders();
    }

    public Map<Integer, Order> getBufferedOrders() {
        return ordersBuffer;
    }

    public Integer createOrder() {
        Integer orderId = this.orderId++; 
        ordersBuffer.put(orderId, new Order()); 
        return orderId;
    }

    public Order addProductToOrder(Integer orderId, String productName, Integer quantity) {
        Order myorder = ordersBuffer.get(orderId);
        if(myorder == null) {
            throw new OrderException("Order not found");
        }

        Product product = productRepository.getProductByName(productName);
        if(product == null) {
            throw new OrderException("Product not found");
        }

        if(product.getQuantity() < quantity) {
            throw new OrderException("Product out of stock");
        }

        product.setQuantity(product.getQuantity() - quantity);

        Product newProduct = new Product(product.getName(), product.getPrice(), quantity, product.getCategory());
        myorder.addProduct(newProduct);

        return myorder;
    }

    public void completeOrder(Integer orderId, Customer customer) {
        Order order = ordersBuffer.get(orderId);
        if(order != null) { 
            Thread newThread = new Thread(() -> { 
                InvoiceRequest invoiceRequest = new InvoiceRequest(customer, order.getProducts());
                InvoiceResponse result = invoiceServiceClient.createInvoice(invoiceRequest);
                
                if(result != null) {
                    order.setIsConfirmed(true);
                    orderRepository.addOrder(order);
                    log.info("Order confirmed: " + orderId);
                    ordersBuffer.remove(orderId);
                } else {
                    log.error("Invoice creation failed");
                }
            });

            newThread.start();
        } else {
            throw new OrderException("Order not found");
        }
    }
 
}
