package com.paras.FreeAPIs.repositories.socialMedia;

import com.paras.FreeAPIs.entities.socialMedia.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
}
