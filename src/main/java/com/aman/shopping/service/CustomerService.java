package com.aman.shopping.service;

import com.aman.shopping.dto.request.CustomerRequestDto;
import com.aman.shopping.dto.response.CustomerResponseDto;
import com.aman.shopping.entity.Customer;

import java.util.Optional;

public interface CustomerService {

    Optional<CustomerResponseDto> addCustomer(CustomerRequestDto customerRequestDto);

    Optional<CustomerResponseDto> findById(Long id);
}
