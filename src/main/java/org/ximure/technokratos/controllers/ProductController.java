package org.ximure.technokratos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ximure.technokratos.models.Product;
import org.ximure.technokratos.services.impl.ProductServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductServiceImpl productServiceImpl;

    @Autowired
    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    // показать все продукты
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productServiceImpl.findAllProducts();
    }
}
