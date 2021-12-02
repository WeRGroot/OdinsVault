package com.shivam.amazonlocker.service;

import com.shivam.amazonlocker.model.notification.Message;
import com.shivam.amazonlocker.model.notification.SimpleMessage;
import com.shivam.amazonlocker.model.order.Order;
import com.shivam.amazonlocker.repository.OrderRepository;

public class OrderService {
    private OrderRepository orderRepository = new OrderRepository();
    private NotificationService notificationService = new ConsoleNotificationService();

    public Order getOrder(String orderId){
        return orderRepository.getOrder(orderId);
    }

    public void addOrder(Order order){
        orderRepository.addOrder(order);
        String messageStr = String.format(SimpleMessage.ORDER_PLACED_MESSAGE, order.getOrderId());
        Message message = new SimpleMessage(messageStr);
        notificationService.sendMessage(message);
    }
}
