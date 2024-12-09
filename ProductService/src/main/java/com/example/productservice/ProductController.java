package com.example.productservice;


import com.example.productservice.customerservice.CustomerRestApi;
import com.example.productservice.customerservice.CustomerService;
import com.example.productservice.entities.Product;
import com.example.productservice.model.Customer;
import com.example.productservice.repository.ProductRepo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductRepo productRepo;



    @Autowired
    private CustomerRestApi customerRestApi;


    @Autowired
    public CustomerService customerService;


    @GetMapping("/list")
    @CircuitBreaker(name = "default",fallbackMethod = "getDefaultCustomer")
    public List<Product> getAllProducts() {
        return productRepo.findAll().stream().map(product -> {
            product.setCustomer(customerRestApi.getCustomer(product.getCustomerId()));
            return product;
        }).collect(Collectors.toList());
    }

    @GetMapping("/list2")

    public List<Product> getAllProducts2() {
        return productRepo.findAll().stream().map(product -> {
            product.setCustomer(customerService.getCustomer(product.getCustomerId()));
            return product;
        }).collect(Collectors.toList());
    }


    public List<Customer> getDefaultCustomer(Exception e){
        return Stream.of(
                new Customer()
        ).collect(Collectors.toList());
    }

}
