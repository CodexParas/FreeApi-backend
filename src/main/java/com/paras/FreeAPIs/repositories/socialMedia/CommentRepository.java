package com.paras.FreeAPIs.repositories.socialMedia;

import com.paras.FreeAPIs.entities.socialMedia.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
