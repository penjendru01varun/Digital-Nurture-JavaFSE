package com.cognizant.customerservice.controller;

import com.cognizant.customerservice.model.Customer;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final Map<Long, Customer> customers = new HashMap<>();

    @PostConstruct
    public void init() {
        customers.put(1L, new Customer(1L, "Alice", "alice@test.com"));
        customers.put(2L, new Customer(2L, "Bob", "bob@test.com"));
    }

    @GetMapping
    public Collection<Customer> getAll() {
        return customers.values();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable Long id) {
        return customers.get(id);
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        long id = customers.size() + 1;
        customer.setId(id);
        customers.put(id, customer);
        return customer;
    }
}
