package com.paras.FreeAPIs.entities.ecommerce;

import com.paras.FreeAPIs.entities.auth.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ecommerce_products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Category category;

    private String name;
    private String description;
    private Double price;
    private String mainImageUrl;
    private Integer stock;

    @ElementCollection
    private List<String> images;

    @ManyToOne
    private User owner;

    private Timestamp createdDate;
    private Timestamp lastModifiedDate;

    @PrePersist
    public void prePersist () {
        this.createdDate = new Timestamp(System.currentTimeMillis());
        this.lastModifiedDate = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    public void preUpdate () {
        this.lastModifiedDate = new Timestamp(System.currentTimeMillis());
    }
}
