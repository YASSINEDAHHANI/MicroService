package com.example.productservice.customerservice;

import com.example.productservice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {


    RestTemplate restTemplate = new RestTemplate();

     final String BaseUrl = "http://localhost:8888/CUSTOMERSERVICE";

    public Customer getCustomer(Long id){

        Customer customer = restTemplate.getForObject(BaseUrl+"/api/customers/"+id, Customer.class);

        return customer;
    }
}
