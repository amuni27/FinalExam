package com.aman.shopping.service.impl;

import com.aman.shopping.dto.request.ProductRequestDto;
import com.aman.shopping.dto.response.ProductResponseDto;
import com.aman.shopping.entity.Product;
import com.aman.shopping.repository.ProductRepository;
import com.aman.shopping.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;


    @Override
    public Optional<ProductResponseDto> addProduct(ProductRequestDto productRequestDto) {
        Product product = modelMapper.map(productRequestDto, Product.class);
        Product savedProduct = productRepository.save(product);
        if (savedProduct != null) {
            ProductResponseDto productResponseDto = modelMapper.map(savedProduct, ProductResponseDto.class);
            return Optional.of(productResponseDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<ProductResponseDto> getProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            ProductResponseDto productResponseDto = modelMapper.map(product.get(), ProductResponseDto.class);
            return Optional.of(productResponseDto);
        }
        return Optional.empty();
    }
}
