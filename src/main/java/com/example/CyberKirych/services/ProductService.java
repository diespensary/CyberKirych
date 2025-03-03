package com.example.CyberKirych.services;

import com.example.CyberKirych.models.Product;
import com.example.CyberKirych.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProductsByTittle(String title) {
        if (title != null && !title.isEmpty()) {
            return productRepository.findByTitle(title);
        }
        return productRepository.findAll();
    }

    public void saveProduct(Product product) {
        log.info("Saving product: " + product);
        productRepository.save(product);
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    public Product getProductByID(Integer id) {
        return productRepository.findById(id).orElse(null);
    }
}
