package com.example.CyberKirych.controllers;

import com.example.CyberKirych.models.Product;
import com.example.CyberKirych.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public String products(@RequestParam(name = "title", required = false)  String title, Model model) {
        model.addAttribute("products", productService.getProductsByTittle(title));
        return "products";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProductByID(id));
        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
