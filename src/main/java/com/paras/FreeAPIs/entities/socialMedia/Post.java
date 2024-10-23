package com.paras.FreeAPIs.entities.socialMedia;

import com.paras.FreeAPIs.entities.auth.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "social_posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ElementCollection
    private List<String> images;

    @ElementCollection
    private List<String> tags;

    @ManyToOne
    private User owner;

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
