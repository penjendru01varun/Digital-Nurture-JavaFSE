package com.cognizant.billingservice.controller;

import com.cognizant.billingservice.model.Invoice;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/billing")
public class BillingController {

    private final Map<Long, Invoice> invoices = new HashMap<>();

    @PostConstruct
    public void init() {
        invoices.put(1L, new Invoice(1L, 1L, 150.00, "PAID"));
        invoices.put(2L, new Invoice(2L, 2L, 250.00, "PENDING"));
    }

    @GetMapping
    public Collection<Invoice> getAll() {
        return invoices.values();
    }

    @GetMapping("/{id}")
    public Invoice getById(@PathVariable Long id) {
        return invoices.get(id);
    }

    @PostMapping
    public Invoice create(@RequestBody Invoice invoice) {
        long id = invoices.size() + 1;
        invoice.setId(id);
        invoices.put(id, invoice);
        return invoice;
    }
}
