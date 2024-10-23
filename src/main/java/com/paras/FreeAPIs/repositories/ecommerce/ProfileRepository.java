package com.paras.FreeAPIs.repositories.ecommerce;

import com.paras.FreeAPIs.entities.ecommerce.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
