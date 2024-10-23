package com.paras.FreeAPIs.entities.ecommerce;

import com.paras.FreeAPIs.entities.auth.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ecommerce_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double orderPrice;

    @Column(nullable = false)
    private Double discountedOrderPrice;

    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private User customer;

    @ElementCollection
    @Column(columnDefinition = "TEXT")
    private List<Object> items = new ArrayList<>();

    @ManyToOne
    private Address address;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum status = OrderStatusEnum.PENDING;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentProviderEnum paymentProvider = PaymentProviderEnum.UNKNOWN;

    private String paymentId;

    @Column(nullable = false)
    private Boolean isPaymentDone = false;

    @Column(updatable = false)
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


    public enum OrderStatusEnum {
        PENDING,
        CONFIRMED,
        SHIPPED,
        DELIVERED,
        CANCELLED
    }

    public enum PaymentProviderEnum {
        RAZORPAY,
        PAYPAL,
        STRIPE,
        UNKNOWN
    }

    public static class OrderItem {
        private Product productId;
        private Integer quantity;
    }
}
