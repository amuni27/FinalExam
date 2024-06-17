package com.aman.shopping.dto.response;

import com.aman.shopping.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {
    private String name;
    private BigDecimal price;
    private Set<OrderResponseDto> orders = new HashSet<>();
}
