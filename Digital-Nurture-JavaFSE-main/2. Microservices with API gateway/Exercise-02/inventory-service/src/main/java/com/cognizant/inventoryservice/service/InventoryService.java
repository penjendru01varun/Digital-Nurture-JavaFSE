package com.cognizant.inventoryservice.service;

import com.cognizant.inventoryservice.model.Stock;
import com.cognizant.inventoryservice.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final StockRepository stockRepository;

    public InventoryService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    public List<Stock> getStockByProductId(Long productId) {
        return stockRepository.findByProductId(productId);
    }

    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public Stock updateQuantity(Long id, Integer quantity) {
        Stock stock = stockRepository.findById(id).orElse(null);
        if (stock != null) {
            stock.setQuantity(quantity);
            return stockRepository.save(stock);
        }
        return null;
    }
}
