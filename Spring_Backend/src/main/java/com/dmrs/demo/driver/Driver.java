package com.dmrs.demo.driver;

import com.dmrs.demo.Auth.user.ApplicationUser;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
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
public class Driver  {

    @Id
    private String id;

    @Indexed(unique = true)
    @DocumentReference
    private ApplicationUser user;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String phone;

    private String jobTitle;
    private String imgUrl;
    private int age;
    private int score;



    public Driver(ApplicationUser user, String firstName, String lastName, Gender gender, String phone,  String jobTitle, String imgUrl, int age) {
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phone = phone;

        this.jobTitle = jobTitle;
        this.imgUrl = imgUrl;
        this.age = age;

    }

    public Driver(String firstName, String lastName, Gender gender, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phone = phone;

    }

}
