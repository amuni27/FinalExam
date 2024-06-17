package com.aman.shopping.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();


    public Customer(String name) {
        this.name = name;
    }
}
