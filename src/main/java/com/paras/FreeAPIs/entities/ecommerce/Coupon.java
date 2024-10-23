package com.paras.FreeAPIs.entities.ecommerce;

import com.paras.FreeAPIs.entities.auth.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ecommerce_coupons")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;

    @Enumerated(EnumType.STRING)
    private CouponTypeEnum type;

    private Double value;
    private boolean isActive;
    private Integer minimumOrderValue;
    private Timestamp validFrom;
    private Timestamp validTill;
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

    public enum CouponTypeEnum {
        PERCENTAGE,
        FLAT
    }
}
