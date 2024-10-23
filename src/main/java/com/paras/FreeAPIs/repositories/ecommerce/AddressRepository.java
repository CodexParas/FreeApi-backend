package com.paras.FreeAPIs.repositories.ecommerce;

import com.paras.FreeAPIs.entities.ecommerce.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
