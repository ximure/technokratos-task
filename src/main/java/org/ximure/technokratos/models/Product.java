package org.ximure.technokratos.models;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    @JoinColumn(name = "article", nullable = false)
    private Long article;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "cost", nullable = false)
    private int cost;
    @Column(name = "available", nullable = false)
    private boolean available;

    public void setName(String name) {
        this.name = name;
    }

    public void setArticle(Long article) {
        this.article = article;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Long getArticle() {
        return article;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public boolean isAvailable() {
        return available;
    }
}
