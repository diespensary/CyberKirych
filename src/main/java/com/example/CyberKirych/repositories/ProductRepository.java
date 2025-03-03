package com.example.CyberKirych.repositories;

import com.example.CyberKirych.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByTitle(String title);


}
