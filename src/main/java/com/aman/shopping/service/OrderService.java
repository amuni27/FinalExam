package com.aman.shopping.service;

import com.aman.shopping.dto.request.OrderRequestDto;
import com.aman.shopping.dto.response.OrderResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Page<OrderResponseDto> findAll(Long customerId,int pageNumber, int pageSize, String direction, String sortBy);
    Optional<OrderResponseDto> addOrder(OrderRequestDto orderRequestDto);
    Optional<OrderResponseDto> getOrder(Long customerId);
}
