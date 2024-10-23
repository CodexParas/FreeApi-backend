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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ecommerce_carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Coupon coupon;

    @ElementCollection
    @Column(columnDefinition = "TEXT")
    private List<Object> items;

    @OneToOne
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
