package com.paras.FreeAPIs.repositories.socialMedia;

import com.paras.FreeAPIs.entities.socialMedia.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
