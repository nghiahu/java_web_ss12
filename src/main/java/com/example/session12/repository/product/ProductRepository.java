package com.example.session12.repository.product;

import com.example.session12.dto.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(int id);
    boolean save(Product product);
    boolean update(Product product);
    boolean delete(int id);
}
