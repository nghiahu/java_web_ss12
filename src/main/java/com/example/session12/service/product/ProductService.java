package com.example.session12.service.product;

import com.example.session12.dto.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
    boolean save(Product product);
    boolean update(Product product);
    boolean delete(int id);
}
