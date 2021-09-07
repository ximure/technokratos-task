package org.ximure.technokratos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.ximure.technokratos.models.Order;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // query, чтобы найти заказы по почте
    @Query("select u from Order u where u.email = ?1")
    List<Order> findByEmail(String email);

    // Это единственное, с чем не справился. Не знаю, как проверить ключ:значение запросом в JPA или
    // же native query и не у кого спросить. Поэтому стоит placeholder :(
    @Query("select u from Order u where u.orderId = ?1")
    List<Order> findByArticle(Long article);

    // query, чтобы найти заказы между датами
    @Query(value = "select u from Order u where u.orderDate >= ?1 and u.orderDate <= ?2")
    List<Order> findBetweenDates(Date from, Date to);
}
