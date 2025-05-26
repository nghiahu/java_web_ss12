package com.example.session12.dto;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Product {
    private int id;
    @NotBlank(message = "Tên sản phẩm không được để trống")
    private String name;
    @Min(value = 1, message = "Đơn giá phải lớn hơn 0")
    private double price;
    @Min(value = 1, message = "Số lượng phải lớn hơn 1")
    private int quantity;
    private transient MultipartFile file;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
