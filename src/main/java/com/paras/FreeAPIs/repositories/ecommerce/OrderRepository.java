package com.paras.FreeAPIs.repositories.ecommerce;

import com.paras.FreeAPIs.entities.ecommerce.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
