package com.aman.shopping.test;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


public class Product {
    private Long customerId;
    private String name;
    private BigDecimal price;
    private Set<Order> orders = new HashSet<>();

    public Product(String name, BigDecimal price, Set<Order> orders) {
        this.name = name;
        this.price = price;
        this.orders = orders;
    }
}
