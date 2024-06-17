package com.aman.shopping.dto.response;

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
public class OrderResponseDto {
    private LocalDate orderDate;
    private CustomerResponseDto customer;
    private Set<ProductResponseDto> products = new HashSet<>();
}
