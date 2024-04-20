package com.example.techtest.data.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@SpringBootApplication
@EnableJpaRepositories("com.example,techtest.data.repositories")
@ComponentScan("persistence.sql")
public class PersistenceConfig {
}
