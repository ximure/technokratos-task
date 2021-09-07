package org.ximure.technokratos.services;

import org.ximure.technokratos.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();
    Product findProductByName(String name);
}
