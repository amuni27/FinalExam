package com.aman.shopping;

import com.aman.shopping.controller.CustomerController;
import com.aman.shopping.dto.response.CustomerResponseDto;
import com.aman.shopping.entity.Customer;
import com.aman.shopping.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

@WebMvcTest(CustomerController.class)

public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;



    @MockBean
    private CustomerService customerService;

    @Test
    void findCustomerByID() throws Exception {
        ModelMapper modelMapper =new ModelMapper();
        Customer customer = new Customer("Amanuel");
        CustomerResponseDto customerResponseDto = modelMapper.map(customer,CustomerResponseDto.class);
        Mockito.when(customerService.findById(1L)).thenReturn(Optional.of(customerResponseDto));
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/customers/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
