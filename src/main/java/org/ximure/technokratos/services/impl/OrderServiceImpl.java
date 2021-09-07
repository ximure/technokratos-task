package org.ximure.technokratos.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ximure.technokratos.models.Order;
import org.ximure.technokratos.repositories.OrderRepository;
import org.ximure.technokratos.models.Product;
import org.ximure.technokratos.services.OrderService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductServiceImpl productServiceImpl;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ProductServiceImpl productServiceImpl) {
        this.orderRepository = orderRepository;
        this.productServiceImpl = productServiceImpl;
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findOrdersByEmail(String email) {
        return orderRepository.findByEmail(email);
    }

    @Override
    public List<Order> findOrdersByArticle(Long article) {
        return orderRepository.findByArticle(article);
    }

    @Override
    public List<Order> findOrdersBetweenDates(String from, String to) {
        try {
            // парсинг даты из string в date
            Date parsedFromDate = new SimpleDateFormat("yyyy-MM-dd").parse(from);
            Date parsedToDate = new SimpleDateFormat("yyyy-MM-dd").parse(to);
            return orderRepository.findBetweenDates(parsedFromDate, parsedToDate);
        } catch (ParseException e) {
            return null;
        }
    }

    @Override
    public Order saveOrder(Order orderList) {
        // берём сегодняшнюю дату
        Date currentDate = new Date();
        // создаём копию orderList'а
        List<Product> productsList = orderList.getOrderList();
        try {
            for (Product productItem : productsList) {
                // меняем для каждого объекта Product поля:
                // 1 - имя на низкий регистр
                // 2, 3 и 4 - цену, артикул и доступен ли продукт - берём данные из списка Products
                productItem.setName(productServiceImpl.findProductByName(productItem.getName().toLowerCase()).getName());
                productItem.setCost(productServiceImpl.findProductByName(productItem.getName()).getCost());
                productItem.setArticle(productServiceImpl.findProductByName(productItem.getName()).getArticle());
                productItem.setAvailable(productServiceImpl.findProductByName(productItem.getName()).isAvailable());
            }
        } catch (NullPointerException e) {
            // если продукта с указанным именем не будет, возвращаем null
            return null;
        }
        // ставим id заказа в виде хэша от текущей даты
        orderList.setOrderId((long) currentDate.hashCode());
        // текущую дату
        orderList.setOrderDate(currentDate);
        // и отредактированный список, который получили в foreach
        orderList.setOrderList(productsList);
        return orderRepository.save(orderList);
    }
}
