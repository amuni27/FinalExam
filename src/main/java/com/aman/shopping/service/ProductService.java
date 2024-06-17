package com.aman.shopping.service;

import com.aman.shopping.dto.request.ProductRequestDto;
import com.aman.shopping.dto.response.ProductResponseDto;

import java.util.Optional;

public interface ProductService {

    Optional<ProductResponseDto> addProduct(ProductRequestDto productRequestDto);

    Optional<ProductResponseDto> getProduct(Long id);
}
