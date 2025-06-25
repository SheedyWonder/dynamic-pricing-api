package com.dynamicpricing.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/product")
public class ProductController {

    private final Map<UUID, Double> productData = new HashMap<>();

    public ProductController() {
        // Sample data
        productData.put(UUID.randomUUID(), 100.0);
        productData.put(UUID.randomUUID(), 200.0);
    }


    @GetMapping("/current-price")
    public ResponseEntity<String> getCurrentPrice(@RequestParam UUID product_id) {
        return ResponseEntity.ok("Price for product: " + product_id);
    }

    @PostMapping("/update-price")
    public Map<String, Object> updatePrice(@RequestParam UUID product_id, @RequestParam Double new_price) {
        productData.put(product_id, new_price);
        return Map.of("product_id", product_id, "updated_price", new_price);
    }


}

