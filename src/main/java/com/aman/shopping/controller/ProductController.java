package com.aman.shopping.controller;


import com.aman.shopping.dto.request.ProductRequestDto;
import com.aman.shopping.dto.response.ProductResponseDto;
import com.aman.shopping.entity.Product;
import com.aman.shopping.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDto> addProduct(@RequestBody ProductRequestDto productRequestDto) {
        Optional<ProductResponseDto> productResponseDto= productService.addProduct(productRequestDto);
        if (productResponseDto.isPresent()){
            return new ResponseEntity<>(productResponseDto.get(), HttpStatus.CREATED);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDto> findByProductId(@PathVariable Long productId) {
        Optional<ProductResponseDto> productResponseDto = productService.getProduct(productId);
        if (productResponseDto.isPresent()){
            return new ResponseEntity<>(productResponseDto.get(),HttpStatus.FOUND);
        }
        return ResponseEntity.noContent().build();
    }
}
