package com.paras.FreeAPIs.entities.auth;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
@Builder
public class User implements UserDetails, Principal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private LoginType loginType;
    private boolean isEmailVerified;
    private String refreshToken;
    private String forgotPasswordToken;
    private Timestamp forgotPasswordExpiry;
    private String emailVerificationToken;
    private Timestamp emailVerificationExpiry;
    private Timestamp createdDate;
    private Timestamp lastModifiedDate;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;
    private boolean accountLocked;
    private boolean enabled;


    @Override
    public String getName () {
        return this.username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities () {
        return this.roles
                .stream()
                .map(r -> new SimpleGrantedAuthority(r.getName().toString()))
                .toList();
    }

    @Override
    public String getPassword () {
        return password;
    }

    @Override
    public String getUsername () {
        return email;
    }

    @Override
    public boolean isAccountNonExpired () {
        return true;
    }

    @Override
    public boolean isAccountNonLocked () {
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired () {
        return true;
    }

    @Override
    public boolean isEnabled () {
        return enabled;
    }

    @PrePersist
    protected void onCreate () {
        this.createdDate = new Timestamp(System.currentTimeMillis());
        this.lastModifiedDate = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate () {
        this.lastModifiedDate = new Timestamp(System.currentTimeMillis());
    }

    public enum LoginType {
        EMAIL_PASSWORD,
        GOOGLE,
        GITHUB
    }
}
