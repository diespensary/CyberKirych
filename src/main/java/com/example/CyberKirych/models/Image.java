package com.example.CyberKirych.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="image")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="originalFilename")
    private String originalFilename;

    @Column(name="contentType")
    private String contentType;

    @Column(name="size")
    private Long size;

    @Column(name="isPreviewImage")
    private boolean isPreviewImage;

    @Lob
    @Column(name="bytes")
    private byte[] bytes;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Product product;
}
