package com.bcnc.techtest.data.adapters.jpa;

import com.bcnc.techtest.data.mappers.ProductEntityMapper;
import com.bcnc.techtest.data.repositories.jpa.ProductRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = ProductRepositoryAdapter.class)
@ExtendWith(MockitoExtension.class)
class ProductRepositoryAdapterTest {

    @MockBean
    private EntityManager entityManager;

    @MockBean
    private ProductRepository repository;

    @MockBean
    private ProductEntityMapper mapper;

    private ProductRepositoryAdapter adapter;

    @BeforeEach
    void setUp()
    {
        this.adapter = new ProductRepositoryAdapter(entityManager, repository, mapper);
    }


}
