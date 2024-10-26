package com.paras.FreeAPIs.entities.socialMedia;

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
@Table(name = "social_follows")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private SocialMediaProfile followerId;

    @ManyToOne
    private SocialMediaProfile followeeId;

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
