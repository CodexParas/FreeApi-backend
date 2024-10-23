package com.paras.FreeAPIs.entities.ecommerce;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paras.FreeAPIs.entities.auth.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ecommerce_categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JsonIgnore
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
