package com.example.CyberKirych.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private Integer id;
    private String title;
    private String description;
    private int price;
    private String city;
    private String author;
}
