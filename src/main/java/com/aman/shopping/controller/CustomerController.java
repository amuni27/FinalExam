package com.aman.shopping.controller;

import com.aman.shopping.dto.request.CustomerRequestDto;
import com.aman.shopping.dto.response.CustomerResponseDto;
import com.aman.shopping.entity.Customer;
import com.aman.shopping.exception.CustomerNotFoundException;
import com.aman.shopping.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody CustomerRequestDto customer) {
        Optional<CustomerResponseDto> customerResponseDto = customerService.addCustomer(customer);
        if(customerResponseDto.isPresent()){
            return new ResponseEntity<>(customerResponseDto.get(), HttpStatus.CREATED);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> findCustomer(@PathVariable Long id) {
        Optional<CustomerResponseDto> customerResponseDto=customerService.findById(id);
        if (customerResponseDto.isPresent()){
            return new ResponseEntity(customerResponseDto.get(),HttpStatus.FOUND);
        }
        throw new CustomerNotFoundException("Can't found customer by the given Id: "+ id);
    }

}
