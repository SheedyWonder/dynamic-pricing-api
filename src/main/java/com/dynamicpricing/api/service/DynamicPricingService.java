package com.dynamicpricing.api.service;

import org.springframework.stereotype.Service;

import com.dynamicpricing.api.model.Product;

import java.math.BigDecimal;

@Service
public class DynamicPricingService {

    private static final BigDecimal MAX_PRICE_INCREASE = BigDecimal.valueOf(0.25); // 25% max increase for high demand
    private static final BigDecimal MIN_PRICE_DECREASE = BigDecimal.valueOf(0.10); // 10% max decrease for low demand
    private static final BigDecimal COMPETITOR_PRICE_ADJUSTMENT = BigDecimal.valueOf(0.05); // 5% adjustment based on competitor price

    public BigDecimal calculateDynamicPrice(Product product, int demandFactor, BigDecimal competitorPrice, int stockLevel, boolean isSeasonal) {

        // Start with the base price
        BigDecimal price = product.getPrice();

        // Adjust based on demand
        if (demandFactor > 70) {
            price = price.add(price.multiply(MAX_PRICE_INCREASE)); // Increase by up to 25% if demand is high
        } else if (demandFactor < 30) {
            price = price.subtract(price.multiply(MIN_PRICE_DECREASE)); // Decrease by up to 10% if demand is low
        }

        // Adjust based on competitor price
        if (competitorPrice.compareTo(price) < 0) {
            price = price.subtract(price.multiply(COMPETITOR_PRICE_ADJUSTMENT)); // Lower the price to stay competitive
        }

        // Adjust based on stock level (scarcity pricing)
        if (stockLevel < 50) {
            price = price.add(price.multiply(BigDecimal.valueOf(0.15))); // Increase by 15% if stock is low (scarcity pricing)
        } else if (stockLevel > 200) {
            price = price.subtract(price.multiply(BigDecimal.valueOf(0.10))); // Decrease by 10% if stock is high
        }

        // Apply seasonal adjustment
        if (isSeasonal) {
            price = price.add(price.multiply(BigDecimal.valueOf(0.20))); // Increase by 20% if the product is in season
        }

        // Ensure the price is above cost (Cost-Based Pricing)
        if (price.compareTo(product.getCostPrice()) < 0) {
            price = product.getCostPrice(); // Don't let the price go below cost
        }

        return price;
    }
}
