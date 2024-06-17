package com.aman.shopping.test;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


public class Customer {
    private Long customerId;
    private String name;
    private List<Order> orders = new ArrayList<>();


    public Customer(String name) {
        this.name = name;
    }
}
