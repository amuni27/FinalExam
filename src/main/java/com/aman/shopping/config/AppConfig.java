package com.aman.shopping.config;


import com.aman.shopping.dto.request.CustomerRequestDto;
import com.aman.shopping.dto.request.OrderRequestDto;
import com.aman.shopping.dto.request.ProductRequestDto;
import com.aman.shopping.dto.response.OrderResponseDto;
import com.aman.shopping.dto.response.ProductResponseDto;
import com.aman.shopping.entity.Customer;
import com.aman.shopping.entity.Order;
import com.aman.shopping.entity.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
//        ModelMapper modelMapper = new ModelMapper();
//
//        modelMapper.addMappings(
//                new PropertyMap<OrderRequestDto, Order>() {
//
//                    @Override
//                    protected void configure() {
//                        map()
//                                .getCustomer()
//                                .setName(source.getCustomer().getName());
//                        map()
//                                .getProducts()
//                                .add(new Product(source.getProducts().getName(), source.getProducts().getPrice(),null));
//
//                    }
//                }
//        );

//        modelMapper.addMappings(
//                new PropertyMap<Order, OrderResponseDto>() {
//
//                    @Override
//                    protected void configure() {
//                        map()
//                                .getCustomer()
//                                .setName(source.getCustomer().getName());
//                        map()
//                                .getProducts()
//                                .stream().forEach(order ->
//                                        source.getProducts().add(
//                                                new Product(order.getName(), order.getPrice(), null)
//                                        )
//                                );
//                    }
//                }
//        );
//
//        return modelMapper;

    }
}
