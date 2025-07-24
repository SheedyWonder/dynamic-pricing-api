package com.dynamicpricing.api.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynamicpricing.api.exception.ProductNotFoundException;
import com.dynamicpricing.api.model.Product;
import com.dynamicpricing.api.repo.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(UUID id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(UUID id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setBasePrice(updatedProduct.getBasePrice());
        existingProduct.setVendor(updatedProduct.getVendor());
        existingProduct.setSku(updatedProduct.getSku());
        existingProduct.setCostPrice(updatedProduct.getCostPrice());
        existingProduct.setStockLevel(updatedProduct.getInventory());
        existingProduct.setDescription(updatedProduct.getDescription());

        return productRepository.save(existingProduct);
    }

    public void deleteProduct(UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        productRepository.delete(product);
    }

}
