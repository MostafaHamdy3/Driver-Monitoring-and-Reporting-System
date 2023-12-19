package com.dmrs.demo.driver;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@NoArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
@Data
@Document
public class Driver implements UserDetails {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String phone;
    @Indexed(unique = true)
    private String email;
    private String password;
    private String jobTitle;
    private String imgUrl;
    private int age;
    private int score;
    private boolean locked = false;
    private boolean enabled = false;


    public Driver(String firstName, String lastName, Gender gender, String phone, String email, String password, String jobTitle, String imgUrl, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.jobTitle = jobTitle;
        this.imgUrl = imgUrl;
        this.age = age;

    }

    public Driver(String firstName, String lastName, Gender gender, String phone, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
