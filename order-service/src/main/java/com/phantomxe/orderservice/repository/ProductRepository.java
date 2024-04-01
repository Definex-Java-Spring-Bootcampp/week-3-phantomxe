package com.phantomxe.orderservice.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.phantomxe.orderservice.entity.Product;
import com.phantomxe.orderservice.enums.ProductCategory;

public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.addAll(List.of(
                new Product("Laptop", 35000.0, 10, ProductCategory.ELECTRONIC),
                new Product("Mouse", 250.0, 100, ProductCategory.ELECTRONIC),
                new Product("Keyboard", 500.0, 50, ProductCategory.ELECTRONIC),
                new Product("Tshirt", 300.0, 20, ProductCategory.CLOTHING),
                new Product("Cordless Drill", 11650.0, 30, ProductCategory.TOOLS),
                new Product("Screwdriver", 150.0, 100, ProductCategory.TOOLS),
                new Product("Screw", 1.0, 1000, ProductCategory.TOOLS),
                new Product("Shampoo", 50.0, 100, ProductCategory.PERSONAL_CARE)
        ));
    }

    public List<Product> getProducts() {
        return products;
    }    

    public Product getProductByName(String name) {
        Optional<Product> item = products.stream().filter(product -> product.getName().equals(name)).findFirst();
        if(item.isPresent()) {
            return item.get();
        } else {
            return null;
        }
    }
}
