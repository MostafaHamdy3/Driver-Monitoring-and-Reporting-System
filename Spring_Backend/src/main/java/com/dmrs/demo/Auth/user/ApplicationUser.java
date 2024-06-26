package com.dmrs.demo.Auth.user;


import jakarta.annotation.security.RolesAllowed;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Data
@Document
public class ApplicationUser implements UserDetails {

    @Id
    private String id;

    @Indexed(unique = true)
    private String username;
    private String password;

    @DocumentReference
    private Set<Role> authorities;
    private boolean locked = false;
    private boolean enabled = true;
    private boolean expired = false;
    private boolean credentialsExpired= false;

    public ApplicationUser( String username, String password, Set<Role> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !this.expired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !credentialsExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
