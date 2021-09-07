package org.ximure.technokratos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ximure.technokratos.models.Order;
import org.ximure.technokratos.services.impl.OrderServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    private final OrderServiceImpl orderServiceImpl;

    @Autowired
    public OrderController(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    // показать все заказы
    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderServiceImpl.findAllOrders();
    }

    // показать заказ по почте
    @GetMapping("/orders/find/email")
    public List<Order> getOrdersByEmail(@RequestParam(value = "email") String email) {
        return orderServiceImpl.findOrdersByEmail(email);
    }

    // показать заказ по артикулу
    @GetMapping("/orders/find/article")
    public List<Order> getOrdersByArticle(@RequestParam(value = "article") Long article) {
        return orderServiceImpl.findOrdersByArticle(article);
    }

    // между двумя датами
    @GetMapping("/orders/find/date")
    public List<Order> getOrdersBetweenDates(@RequestParam(value = "from") String from,
                                             @RequestParam(value = "to") String to) {
        return orderServiceImpl.findOrdersBetweenDates(from, to);
    }

    // создать новый заказ
    @ResponseBody
    @PostMapping(value = "/orders/new", consumes = "application/json", produces = "application/json")
    public Order addNewOrder(@RequestBody Order orderList) {
        return orderServiceImpl.saveOrder(orderList);
    }
}
