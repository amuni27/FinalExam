package com.aman.shopping.dto.request;

import com.aman.shopping.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestDto {
    private String name;
    private List<OrderRequestDto> orders = new ArrayList<>();
}
