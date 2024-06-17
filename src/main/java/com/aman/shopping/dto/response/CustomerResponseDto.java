package com.aman.shopping.dto.response;

import com.aman.shopping.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseDto {
    private String name;
    private List<OrderResponseDto> orders = new ArrayList<>();
}
