package com.cognizant.inventoryservice.controller;

import com.cognizant.inventoryservice.model.Stock;
import com.cognizant.inventoryservice.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public List<Stock> getAllStock() {
        return inventoryService.getAllStock();
    }

    @GetMapping("/product/{productId}")
    public List<Stock> getStockByProductId(@PathVariable Long productId) {
        return inventoryService.getStockByProductId(productId);
    }

    @PostMapping
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock) {
        Stock created = inventoryService.addStock(stock);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PatchMapping("/{id}/quantity")
    public ResponseEntity<Stock> updateQuantity(@PathVariable Long id, @RequestBody Map<String, Integer> body) {
        Stock updated = inventoryService.updateQuantity(id, body.get("quantity"));
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
}
