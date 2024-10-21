package com.paras.FreeAPIs.entities.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private RoleName name;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<User> users;

    @Column(updatable = false, nullable = false)
    private Timestamp createdDate;

    @Column(insertable = false)
    private Timestamp lastModifiedDate;

    @PrePersist
    protected void onCreate () {
        this.createdDate = new Timestamp(System.currentTimeMillis());
        this.lastModifiedDate = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate () {
        this.lastModifiedDate = new Timestamp(System.currentTimeMillis());
    }

    public enum RoleName {
        ROLE_USER,
        ROLE_ADMIN
    }
}


