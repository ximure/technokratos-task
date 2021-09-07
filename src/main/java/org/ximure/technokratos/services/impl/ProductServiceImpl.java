package org.ximure.technokratos.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ximure.technokratos.models.Product;
import org.ximure.technokratos.repositories.ProductRepository;
import org.ximure.technokratos.services.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductByName(String name) {
        return productRepository.findByName(name);
    }
}
