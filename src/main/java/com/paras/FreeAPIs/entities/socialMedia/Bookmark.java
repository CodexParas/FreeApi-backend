package com.paras.FreeAPIs.entities.socialMedia;

import com.paras.FreeAPIs.entities.auth.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "social_bookmarks")
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User bookmarkedBy;

    private Timestamp createdAt;
    private Timestamp lastModifiedAt;

    @PrePersist
    public void prePersist () {
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.lastModifiedAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    public void preUpdate () {
        this.lastModifiedAt = new Timestamp(System.currentTimeMillis());
    }
}
