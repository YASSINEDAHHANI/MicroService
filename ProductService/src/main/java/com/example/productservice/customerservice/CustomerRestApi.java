package com.example.productservice.customerservice;


import com.example.productservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("CustomerService")

public interface CustomerRestApi {

    @GetMapping("/api/customers/{id}")
     Customer getCustomer(@PathVariable long id);





}
