package com.dynamicpricing.api.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dynamicpricing.api.dto.ProductDTO;
import com.dynamicpricing.api.exception.ResourceNotFoundException;
import com.dynamicpricing.api.model.Product;
import com.dynamicpricing.api.repo.ProductRepository;
import com.dynamicpricing.api.service.DynamicPricingService;
import com.dynamicpricing.api.service.ProductService;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    private final DynamicPricingService dynamicPricingService;
    private final ProductRepository productRepository;

    
    public ProductController(DynamicPricingService dynamicPricingService, ProductRepository productRepository) {
        this.dynamicPricingService = dynamicPricingService;
        this.productRepository = productRepository;
    }

    @GetMapping("/{productId}/price")
    public ResponseEntity<Double> getDynamicPrice(@PathVariable UUID productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        // Simulate parameters for dynamic pricing calculation
        int demandFactor = 80; // Example demand factor
        int competitorPrice = 90; // Example competitor price
        int stockLevel = 40; // Example stock level
        boolean isSeasonal = true; // Example seasonal flag

        double dynamicPrice = dynamicPricingService.calculateDynamicPrice(
                product, demandFactor, competitorPrice, stockLevel, isSeasonal);

        return ResponseEntity.ok(dynamicPrice);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable UUID id) {
        Product product = productService.getProductById(id);
        ProductDTO productDTO = new ProductDTO(product.getId(), product.getName(), product.getPrice());
        return ResponseEntity.ok(productDTO);
    }
}

