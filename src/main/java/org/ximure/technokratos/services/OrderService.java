package org.ximure.technokratos.services;

import org.ximure.technokratos.models.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAllOrders();
    List<Order> findOrdersByEmail(String email);
    List<Order> findOrdersByArticle(Long article);
    List<Order> findOrdersBetweenDates(String from, String to);
    Order saveOrder(Order orderList);
}
