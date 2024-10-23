package com.paras.FreeAPIs.repositories.socialMedia;

import com.paras.FreeAPIs.entities.socialMedia.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
