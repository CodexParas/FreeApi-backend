package com.paras.FreeAPIs.repositories.ecommerce;

import com.paras.FreeAPIs.entities.ecommerce.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
