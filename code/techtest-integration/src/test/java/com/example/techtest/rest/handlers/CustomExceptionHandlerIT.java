package com.example.techtest.rest.handlers;

import com.example.techtest.openapi.model.ProductDTO;
import com.example.techtest.openapi.model.ProductInfoDTO;
import com.example.techtest.rest.controllers.ProductController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static com.example.techtest.domain.constants.CurrencyConstants.EURO;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(CustomExceptionHandler.class)
class CustomExceptionHandlerIT {
    @MockBean
    private ProductController controller;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void shouldCreateMockMvc() {
        assertNotNull(mockMvc);
    }

    @Test
    void customHandlerException_notFound() throws Exception {
        when(this.controller.getProduct(any(), any(), any())).thenReturn(new ResponseEntity<>(new ProductInfoDTO(), HttpStatusCode.valueOf(HttpStatus.NOT_FOUND.value())));
        mockMvc.perform(get("/products/1/brand/1/date/2020-06-13T00:00:00")
            .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isNotFound());
    }

    @Test
    void customHandlerException_badRequest() throws Exception {
        when(this.controller.createProduct(any())).thenReturn(new ResponseEntity<>(new ProductDTO(), HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value())));
        mockMvc.perform(post("/products")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{}"))
          .andExpect(status().isBadRequest());
    }

    @Test
    void customHandlerException_conflict() throws Exception {
        when(this.controller.createProduct(any())).thenReturn(new ResponseEntity<>(new ProductDTO(), HttpStatusCode.valueOf(HttpStatus.CONFLICT.value())));
        mockMvc.perform(post("/products")
            .contentType(MediaType.APPLICATION_JSON)
            .content(this.setRequestBody()))
          .andExpect(status().isConflict());
    }

    @Test
    void customHandlerException_internalServerError() throws Exception {
        when(this.controller.createProduct(any())).thenReturn(new ResponseEntity<>(new ProductDTO(), HttpStatusCode.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value())));
        mockMvc.perform(post("/products")
            .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isInternalServerError())
          .andExpect(result -> assertInstanceOf(Exception.class, result.getResolvedException()));
    }

    private String setRequestBody() throws Exception
    {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this.setUpProductDTO());
    }

    private ProductDTO setUpProductDTO()
    {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setBrandId(BigDecimal.valueOf(1));
        productDTO.setProductId(BigDecimal.valueOf(1));
        productDTO.setPriceList(1);
        productDTO.setPriority(0);
        productDTO.setStartDate("2020-06-14T00:00:00");
        productDTO.setEndDate("2020-12-31T23:59:59");
        productDTO.setPrice(BigDecimal.valueOf(10.00));
        productDTO.setCurrency(EURO);
        return productDTO;
    }

}
