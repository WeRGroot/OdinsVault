package com.shivam.amazonlocker.repository;

import com.shivam.amazonlocker.model.order.Order;
import java.util.HashMap;
import java.util.Map;

public class OrderRepository {
    private static Map<String, Order> orderStore = new HashMap<>();

    public Order getOrder(String orderId){
        return orderStore.get(orderId);
    }

    public void addOrder(Order order){
        orderStore.put(order.getOrderId(), order);
    }
}
