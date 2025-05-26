package com.example.session12.service.product;

import com.example.session12.dto.Product;
import com.example.session12.repository.product.ProductRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepositoryImp productRepositoryImp;

    @Override
    public List<Product> findAll() {
        return productRepositoryImp.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepositoryImp.findById(id);
    }

    @Override
    public boolean save(Product product) {
        return productRepositoryImp.save(product);
    }

    @Override
    public boolean update(Product product) {
        return productRepositoryImp.update(product);
    }

    @Override
    public boolean delete(int id) {
        return productRepositoryImp.delete(id);
    }
}
