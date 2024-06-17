package com.aman.shopping.controller;


import com.aman.shopping.dto.request.OrderRequestDto;
import com.aman.shopping.dto.response.OrderResponseDto;
import com.aman.shopping.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        Optional<OrderResponseDto> orderResponseDto = orderService.addOrder(orderRequestDto);
        if (orderResponseDto.isPresent()) {
            return new ResponseEntity<>(orderResponseDto.get(), HttpStatus.CREATED);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<OrderResponseDto> getOrderByCustomerId(@PathVariable Long customerId) {
        Optional<OrderResponseDto> orderResponseDto = orderService.getOrder(customerId);
        if (orderResponseDto.isPresent()) {
            return new ResponseEntity<>(orderResponseDto.get(), HttpStatus.FOUND);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{customerId}/{pageNo}/{pageSize}/{direction}/{sortBy}")
    public ResponseEntity<List<OrderResponseDto>> getAllOrder(
            @PathVariable Long customerId,
            @PathVariable Integer pageNo,
            @PathVariable Integer pageSize,
            @PathVariable String direction,
            @PathVariable String sortBy
    ) {
        Page<OrderResponseDto> orderResponseDtos = orderService.findAll(customerId,pageNo, pageSize, direction, sortBy);
        if (orderResponseDtos.getTotalElements() > 0) {
            return ResponseEntity.ok(orderResponseDtos.getContent());
        }
        return ResponseEntity.noContent().build();
    }
}
