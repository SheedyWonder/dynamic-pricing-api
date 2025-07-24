package com.dynamicpricing.api.service;

import com.dynamicpricing.api.exception.OrderNotFoundException;
import com.dynamicpricing.api.model.Order;
import com.dynamicpricing.api.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order getOrderById(UUID id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    public Order createOrder(Order order) {

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order updateOrder(UUID id, Order updatedOrder) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        existingOrder.setProduct(updatedOrder.getProduct());
        existingOrder.setVendor(updatedOrder.getVendor());
        existingOrder.setQuantity(updatedOrder.getQuantity());
        existingOrder.setPriceAtPurchase(updatedOrder.getPriceAtPurchase());
        existingOrder.setTimestamp(updatedOrder.getTimestamp());

        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(UUID id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        orderRepository.delete(order);
    }
}
