package com.aman.shopping.repository;

import com.aman.shopping.entity.Customer;
import com.aman.shopping.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findByCustomer(Customer customer);

}
