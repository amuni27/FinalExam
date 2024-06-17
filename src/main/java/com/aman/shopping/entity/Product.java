package com.aman.shopping.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private BigDecimal price;

    @ManyToMany(mappedBy = "products")
    private Set<Order> orders = new HashSet<>();

    public Product(String name, BigDecimal price, Set<Order> orders) {
        this.name = name;
        this.price = price;
        this.orders = orders;
    }
}
