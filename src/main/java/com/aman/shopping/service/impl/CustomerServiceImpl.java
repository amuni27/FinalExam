package com.aman.shopping.service.impl;

import com.aman.shopping.dto.request.CustomerRequestDto;
import com.aman.shopping.dto.response.CustomerResponseDto;
import com.aman.shopping.entity.Customer;
import com.aman.shopping.repository.CustomerRepository;
import com.aman.shopping.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<CustomerResponseDto> addCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = modelMapper.map(customerRequestDto, Customer.class);
        customer = customerRepository.save(customer);
        CustomerResponseDto customerResponseDto = modelMapper.map(customer, CustomerResponseDto.class);
        return Optional.of(customerResponseDto);
    }

    @Override
    public Optional<CustomerResponseDto> findById(Long id) {
        System.out.println("I am here");
        Optional<Customer> customer= customerRepository.findById(id);
        if (customer.isPresent()){

            CustomerResponseDto customerResponseDto = modelMapper.map(customer.get(),CustomerResponseDto.class);
            return Optional.of(customerResponseDto);
        }
        return Optional.empty();
    }
}
