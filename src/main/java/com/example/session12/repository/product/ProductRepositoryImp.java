package com.example.session12.repository.product;

import com.example.session12.config.ConnectionDB;
import com.example.session12.dto.Product;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImp implements ProductRepository {

    @Override
    public List<Product> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> products = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call getAllProduct()}");
            callSt.execute();
            ResultSet rs = callSt.getResultSet();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setImage(rs.getString("image"));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return products;
    }

    @Override
    public Product findById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Product product = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call searchProductById(?)}");
            callSt.setInt(1, id);
            callSt.execute();
            ResultSet rs = callSt.getResultSet();
            if (rs.next()) {
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setImage(rs.getString("image"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return product;
    }

    @Override
    public boolean save(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call createProduct(?, ?, ?, ?)}");
            callSt.setString(1, product.getName());
            callSt.setDouble(2, product.getPrice());
            callSt.setInt(3, product.getQuantity());
            callSt.setString(4, product.getImage());
            callSt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean update(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call editProduct(?, ?, ?, ?, ?)}");
            callSt.setInt(1, product.getId());
            callSt.setString(2, product.getName());
            callSt.setDouble(3, product.getPrice());
            callSt.setInt(4, product.getQuantity());
            callSt.setString(5, product.getImage());
            callSt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call deleteProduct(?)}");
            callSt.setInt(1, id);
            callSt.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }
}