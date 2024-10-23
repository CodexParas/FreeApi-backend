package com.paras.FreeAPIs.repositories.socialMedia;

import com.paras.FreeAPIs.entities.socialMedia.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long> {
}
