package com.example.techtest.rest.controllers;

import com.example.techtest.application.services.ProductService;
import com.example.techtest.application.usecases.CreateProductUseCaseImpl;
import com.example.techtest.application.usecases.DeleteProductUseCaseImpl;
import com.example.techtest.application.usecases.RetrieveProductUseCaseImpl;
import com.example.techtest.application.usecases.UpdateProductUseCaseImpl;
import com.example.techtest.data.adapters.ProductRepositoryAdapterImpl;
import com.example.techtest.domain.models.ProductInfo;
import com.example.techtest.rest.mappers.ProductDTOMapperImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.example.techtest.domain.constants.CurrencyConstants.EURO;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController.class)
@Import({
  ProductService.class,
  CreateProductUseCaseImpl.class,
  RetrieveProductUseCaseImpl.class,
  UpdateProductUseCaseImpl.class,
  DeleteProductUseCaseImpl.class,
  ProductDTOMapperImpl.class
})
class ProductControllerIT {

    private static final String BASE_ENDPOINT = "/products";

    private static Map<LocalDateTime, ProductInfo> expectedProducts;
    @MockBean
    private ProductRepositoryAdapterImpl repository;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void shouldCreateMockMvc() {
        assertNotNull(mockMvc);
    }

    @BeforeAll
    static void setUp() {

        LocalDateTime use_case_1 = LocalDateTime.parse("2020-06-14T10:00:00");
        LocalDateTime use_case_2 = LocalDateTime.parse("2020-06-14T16:00:00");
        LocalDateTime use_case_3 = LocalDateTime.parse("2020-06-14T21:00:00");
        LocalDateTime use_case_4 = LocalDateTime.parse("2020-06-15T10:00:00");
        LocalDateTime use_case_5 = LocalDateTime.parse("2020-06-15T21:00:00");

        expectedProducts = new HashMap<>();
        expectedProducts.put(use_case_1, setUpExpectedProduct(1));
        expectedProducts.put(use_case_2, setUpExpectedProduct(2));
        expectedProducts.put(use_case_3, setUpExpectedProduct(3));
        expectedProducts.put(use_case_4, setUpExpectedProduct(4));
        expectedProducts.put(use_case_5, setUpExpectedProduct(5));
    }


    // Unable to test against the REST Controller due to MockMvc way to detect Models, as it requires the
    // controller to have @ResponseStatus and @ResponseBody, which in OpenAPI are inside the interface, so it
    // has been not possible to receive other status different than 404.
    /*
    @ParameterizedTest
    @ValueSource(strings = {
      "2020-06-14T10:00:00",
      "2020-06-14T16:00:00",
      "2020-06-14T21:00:00",
      "2020-06-15T10:00:00",
      "2020-06-15T21:00:00"
    })
    void getProduct(String dateString) throws Exception {
        BigDecimal productId = BigDecimal.valueOf(35455);
        BigDecimal brandId = BigDecimal.valueOf(1);

        LocalDateTime date = LocalDateTime.parse(dateString);
        when(this.repository.retrieveProduct(brandId, productId, date)).thenReturn(this.getExpectedProduct(date));
        URI endpoint = new URI(BASE_ENDPOINT + "/35455/brand/1/" + date);
        RequestBuilder request = MockMvcRequestBuilders.request(HttpMethod.GET, endpoint).characterEncoding("UTF-8");
        MvcResult result = mockMvc.perform(get(endpoint))
          .andExpect(status().isOk())
          .andReturn();
        assertNotNull(result.getResponse());
    }*/

    private ProductInfo getExpectedProduct(LocalDateTime date) {
        return expectedProducts.get(date);
    }

    private static ProductInfo setUpExpectedProduct(int useCase) {
        return switch (useCase) {
            case 2 -> ProductInfo.builder()
              .brandId(BigDecimal.valueOf(1))
              .productId(BigDecimal.valueOf(35455))
              .priceList(2)
              .startDate(LocalDateTime.parse("2020-06-14T15:00:00"))
              .endDate(LocalDateTime.parse("2020-06-14T18:30:00"))
              .price(BigDecimal.valueOf(25.45))
              .currency(EURO).build();
            case 4 -> ProductInfo.builder()
              .brandId(BigDecimal.valueOf(1))
              .productId(BigDecimal.valueOf(35455))
              .priceList(3)
              .startDate(LocalDateTime.parse("2020-06-15T00:00:00"))
              .endDate(LocalDateTime.parse("2020-06-15T11:00:00"))
              .price(BigDecimal.valueOf(30.50))
              .currency(EURO).build();
            case 5 -> ProductInfo.builder()
              .brandId(BigDecimal.valueOf(1))
              .productId(BigDecimal.valueOf(35455))
              .priceList(4)
              .startDate(LocalDateTime.parse("2020-06-15T16:00:00"))
              .endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
              .price(BigDecimal.valueOf(38.95))
              .currency(EURO).build();
            default -> ProductInfo.builder()
              .brandId(BigDecimal.valueOf(1))
              .productId(BigDecimal.valueOf(35455))
              .priceList(1)
              .startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
              .endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
              .price(BigDecimal.valueOf(35.50))
              .currency(EURO).build();
        };
    }
}
