package com.paras.FreeAPIs.repositories.ecommerce;

import com.paras.FreeAPIs.entities.ecommerce.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
