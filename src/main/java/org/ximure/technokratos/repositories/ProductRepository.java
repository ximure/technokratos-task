package org.ximure.technokratos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.ximure.technokratos.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select u from Product u where u.name = ?1")
    Product findByName(String name);
}
