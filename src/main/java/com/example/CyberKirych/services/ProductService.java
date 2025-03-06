package com.example.CyberKirych.services;

import com.example.CyberKirych.models.Image;
import com.example.CyberKirych.models.Product;
import com.example.CyberKirych.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
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

    public void saveProduct(Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            product.addImageToProduct(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            product.addImageToProduct(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            product.addImageToProduct(image3);
        }

        log.info("Saving new product. Author: {}", product.getAuthor());
        if (!product.getImages().isEmpty()) {
            Image previousImage = product.getImages().get(0);
            product.setPreviewImageId(previousImage.getId());
        }

        productRepository.save(product);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFilename(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public Product getProductByID(Integer id) {
        return productRepository.findByIdWithImages(id);
    }
}
