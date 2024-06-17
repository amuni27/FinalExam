package com.aman.shopping.test;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class Order {
    private Long orderId;
    private LocalDate orderDate;
    private Customer customer;
    private Set<Product> products = new HashSet<>();

}
