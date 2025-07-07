package com.dynamicpricing.api.service;

import org.springframework.stereotype.Service;

import com.dynamicpricing.api.model.Product;

@Service
public class DynamicPricingService {

    private static final double MAX_PRICE_INCREASE = 0.25; // 25% max increase for high demand
    private static final double MIN_PRICE_DECREASE = 0.10; // 10% max decrease for low demand
    private static final double COMPETITOR_PRICE_ADJUSTMENT = 0.05; // 5% adjustment based on competitor price

    public double calculateDynamicPrice(Product product, int demandFactor, int competitorPrice, int stockLevel, boolean isSeasonal) {

        // Start with the base price
        double price = product.getPrice();

        // Adjust based on demand
        if (demandFactor > 70) {
            price += price * MAX_PRICE_INCREASE; // Increase by up to 25% if demand is high
        } else if (demandFactor < 30) {
            price -= price * MIN_PRICE_DECREASE; // Decrease by up to 10% if demand is low
        }

        // Adjust based on competitor price
        if (competitorPrice < price) {
            price -= price * COMPETITOR_PRICE_ADJUSTMENT; // Lower the price to stay competitive
        }

        // Adjust based on stock level (scarcity pricing)
        if (stockLevel < 50) {
            price += price * 0.15; // Increase by 15% if stock is low (scarcity pricing)
        } else if (stockLevel > 200) {
            price -= price * 0.10; // Decrease by 10% if stock is high
        }

        // Apply seasonal adjustment
        if (isSeasonal) {
            price += price * 0.20; // Increase by 20% if the product is in season
        }

        // Ensure the price is above cost (Cost-Based Pricing)
        if (Double.compare(price, product.getCostPrice().doubleValue()) < 0) {
            price = product.getCostPrice().doubleValue(); // Don't let the price go below cost
        }

        return price;
    }
}
