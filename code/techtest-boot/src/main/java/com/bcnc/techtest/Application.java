package com.bcnc.techtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bcnc.techtest")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
