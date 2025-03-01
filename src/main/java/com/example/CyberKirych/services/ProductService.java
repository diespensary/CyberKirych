package com.example.CyberKirych.services;

import com.example.CyberKirych.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private Integer ID = 0;

    {
        products.add(new Product(++ID, "PS5", "pska", 100, "MSK", "user1"));
        products.add(new Product(++ID, "ps4", "ps", 50, "spb", "user2"));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void saveProduct(Product product) {
        product.setId(++ID);
        products.add(product);
    }

    public void deleteProduct(Integer id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductByID(Integer id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }
}
