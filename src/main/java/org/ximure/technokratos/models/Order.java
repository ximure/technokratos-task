package org.ximure.technokratos.models;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@TypeDef(name = "json", typeClass = JsonBinaryType.class)
@SuppressWarnings("unused")
@Table(name = "orders")
@Entity
public class Order {
    @Id
    @Column(name = "ordernumber")
    private Long orderId;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "date")
    private Date orderDate;
    @Column(name = "orderlist", nullable = false)
    @Type(type = "json")
    private List<Product> orderList;

    public void setOrderList(List<Product> order_list) {
        this.orderList = order_list;
    }

    public void setOrderDate(Date order_date) {
        this.orderDate = order_date;
    }

    public void setOrderId(Long order_id) {
        this.orderId = order_id;
    }

    // используются спрингом, поэтому выключена проверка на неиспользуемые методы
    public Long getOrderId() {
        return orderId;
    }

    public String getEmail() {
        return email;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public List<Product> getOrderList() {
        return orderList;
    }
}

