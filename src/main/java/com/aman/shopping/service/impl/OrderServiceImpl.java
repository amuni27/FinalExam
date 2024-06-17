package com.aman.shopping.service.impl;


import com.aman.shopping.dto.request.OrderRequestDto;
import com.aman.shopping.dto.response.OrderResponseDto;
import com.aman.shopping.entity.Customer;
import com.aman.shopping.entity.Order;
import com.aman.shopping.repository.CustomerRepository;
import com.aman.shopping.repository.OrderRepository;
import com.aman.shopping.service.CustomerService;
import com.aman.shopping.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;


    @Override
    public Page<OrderResponseDto> findAll(Long customerId, int pageNumber, int pageSize, String direction, String sortBy) {
        Pageable pageable = PageRequest.of(
                pageNumber,
                pageSize,
                Sort.Direction.fromString(direction),
                sortBy);

        Page<Order> orderPage = orderRepository.findAll(pageable);
        List<OrderResponseDto> orderResponseDtoList =
                orderPage.stream().filter(order -> order.getCustomer().getCustomerId() == customerId).map(order -> modelMapper.map(order, OrderResponseDto.class)).toList();
        return new PageImpl<>(orderResponseDtoList, pageable, orderPage.getTotalElements());
    }

    @Override
    public Optional<OrderResponseDto> addOrder(OrderRequestDto orderRequestDto) {
        Order order = modelMapper.map(orderRequestDto, Order.class);
        Order savedOrder = orderRepository.save(order);
        if (savedOrder != null) {
            OrderResponseDto orderResponseDto = modelMapper.map(order, OrderResponseDto.class);
            return Optional.of(orderResponseDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<OrderResponseDto> getOrder(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            Optional<Order> order = orderRepository.findByCustomer(customer.get());
            if (order.isPresent()) {
                OrderResponseDto orderResponseDto = modelMapper.map(order, OrderResponseDto.class);
                return Optional.of(orderResponseDto);
            }
        }
        return Optional.empty();
    }
}
