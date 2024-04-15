package com.bcnc.techtest.rest.controllers;

import com.bcnc.techtest.rest.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


/**
 * Integration Tests for {@link ProductController}
 */
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class ProductControllerIT {

    private final MockMvc mockMvc;

    @Autowired
    public ProductControllerIT(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void retrieveProduct_IT_case1() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("products/{productId}/brand/{brandId}/date/{dateId}",
            "35455", "1", "2020-06-14T10:00:00Z"))
          .andDo(MockMvcResultHandlers.print())
          .andExpect(MockMvcResultMatchers.status().isOk())
          .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
          .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
          .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(1))
          .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14T00.00.00Z"))
          .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31T23.59.59Z"))
          .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.50))
          .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value("EUR"));
    }

    @Test
    void retrieveProduct_IT_case2() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("products/{productId}/brand/{brandId}/date/{dateId}",
            "35455", "1", "2020-06-14T10:00:00Z"))
          .andDo(MockMvcResultHandlers.print())
          .andExpect(MockMvcResultMatchers.status().isOk())
          .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
          .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
          .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(2))
          .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14T15.00.00Z"))
          .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-06-14T18.30.00Z"))
          .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(25.45))
          .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value("EUR"));
    }

    @Test
    void retrieveProduct_IT_case3() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("products/{productId}/brand/{brandId}/date/{dateId}",
            "35455", "1", "2020-06-14T10:00:00Z"))
          .andDo(MockMvcResultHandlers.print())
          .andExpect(MockMvcResultMatchers.status().isOk())
          .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
          .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
          .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(1))
          .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14T00.00.00Z"))
          .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31T23.59.59Z"))
          .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.50))
          .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value("EUR"));
    }

    @Test
    void retrieveProduct_IT_case4() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("products/{productId}/brand/{brandId}/date/{dateId}",
            "35455", "1", "2020-06-14T10:00:00Z"))
          .andDo(MockMvcResultHandlers.print())
          .andExpect(MockMvcResultMatchers.status().isOk())
          .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
          .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
          .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(3))
          .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-15T00.00.00Z"))
          .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-06-15T11.00.00Z"))
          .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(30.50))
          .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value("EUR"));
    }

    @Test
    void retrieveProduct_IT_case5() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("products/{productId}/brand/{brandId}/date/{dateId}",
            "35455", "1", "2020-06-14T10:00:00Z"))
          .andDo(MockMvcResultHandlers.print())
          .andExpect(MockMvcResultMatchers.status().isOk())
          .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
          .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
          .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(4))
          .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-15T16.00.00Z"))
          .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31T23.59.59Z"))
          .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(38.95))
          .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value("EUR"));
    }

}
