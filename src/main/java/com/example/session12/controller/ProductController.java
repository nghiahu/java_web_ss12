package com.example.session12.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.session12.dto.Product;
import com.example.session12.service.product.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    private ProductServiceImp productServiceImp;
    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("listProduct")
    public String listProduct(Model model) {
        model.addAttribute("products", productServiceImp.findAll());
        return "listProduct";
    }

    @GetMapping("addProduct")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @GetMapping("editProduct")
    public String editProduct(@RequestParam("id") int id, Model model) {
        model.addAttribute("product", productServiceImp.findById(id));
        return "editProduct";
    }

    @PostMapping("product-save")
    public String saveProduct(@Valid @ModelAttribute("product") Product product,
                              BindingResult bindingResult,
                              @RequestParam("file") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            return "addProduct";
        }
        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String url = (String) uploadResult.get("url");
            if (url == null && url.isEmpty()) {
                throw  new RuntimeException("Invalid URL");
            }
            product.setImage(url);
            System.out.println(url);
        }catch (Exception e) {
            e.printStackTrace();
        }
        productServiceImp.save(product);
        return "redirect:/listProduct";
    }

    @PostMapping("product-edit")
    public String updateProduct(@Valid @ModelAttribute("product") Product product,
                                BindingResult result,
                                @RequestParam("file") MultipartFile file) {
        if (result.hasErrors()) {
            return "editProduct";
        }
        try {
            if (file != null && !file.isEmpty()) {
                Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
                String url = (String) uploadResult.get("url");
                if (url == null || url.isEmpty()) {
                    throw new RuntimeException("Invalid URL");
                }
                product.setImage(url);
            } else {
                Product oldProduct = productServiceImp.findById(product.getId());
                product.setImage(oldProduct.getImage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        productServiceImp.update(product);
        return "redirect:/listProduct";
    }

    @GetMapping("delProduct")
    public String deleteProduct(@RequestParam("id") int id) {
        productServiceImp.delete(id);
        return "redirect:/listProduct";
    }
}
