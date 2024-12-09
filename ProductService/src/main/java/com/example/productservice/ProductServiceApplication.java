package com.example.productservice;

import com.example.productservice.entities.Product;
import com.example.productservice.model.Customer;
import com.example.productservice.repository.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepo p ){
        return args -> {
            p.save(new Product(null,"prd1","prd1 descr",22.00,Long.valueOf(1)));
        };
    }
}
