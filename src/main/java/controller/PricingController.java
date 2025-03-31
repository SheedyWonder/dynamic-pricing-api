package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/pricing")
public class PricingController {

    private final Map<String, Double> priceData = new HashMap<>();

    public PricingController() {
        // Sample data
        priceData.put("product_1", 100.0);
        priceData.put("product_2", 200.0);
    }


    @GetMapping("/current-price")
    public ResponseEntity<String> getCurrentPrice(@RequestParam String product_id) {
        return ResponseEntity.ok("Price for product: " + product_id);
    }

    @PostMapping("/update-price")
    public Map<String, Object> updatePrice(@RequestParam String product_id, @RequestParam Double new_price) {
        priceData.put(product_id, new_price);
        return Map.of("product_id", product_id, "updated_price", new_price);
    }


}

