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
@Table(name = "social_comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    private Post postId;

    @ManyToOne
    private User author;

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
