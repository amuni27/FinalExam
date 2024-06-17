package com.aman.shopping.dto.request;


import com.aman.shopping.entity.Customer;
import com.aman.shopping.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {
    private LocalDate orderDate;
    private CustomerRequestDto customer;
    private Set<ProductRequestDto> products = new HashSet<>();
}
