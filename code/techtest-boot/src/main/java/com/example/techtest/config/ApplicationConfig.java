package com.example.techtest.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.techtest.data")
public class ApplicationConfig {

    private final Environment env;

    public ApplicationConfig(Environment env) {
        this.env = env;
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource h2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
      final EntityManagerFactoryBuilder emBuilder,
      final JpaProperties jpaConfiguration) {
        final Map<String, String> properties = jpaConfiguration.getProperties();
        return emBuilder.dataSource(this.h2DataSource())
          .persistenceUnit("primaryPersistenceUnit")
          .packages("com.example.techtest")
          .properties(properties)
          .jta(false)
          .build();
    }

    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
