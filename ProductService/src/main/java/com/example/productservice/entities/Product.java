package com.example.productservice.entities;


import com.example.productservice.model.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    @Transient
    private Customer customer;
    private Long customerId;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Product(Long id, String name, String description, double price, Long customerId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;

        this.customerId = customerId;

    }
}
