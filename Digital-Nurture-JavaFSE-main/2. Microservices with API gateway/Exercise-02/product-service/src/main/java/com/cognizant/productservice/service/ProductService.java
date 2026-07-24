package com.cognizant.productservice.service;

import com.cognizant.productservice.model.Product;
import com.cognizant.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateStock(Long id, Integer stock) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setStock(stock);
            return productRepository.save(product);
        }
        return null;
    }
}
