package com.dmrs.demo.Auth.registration;

import com.dmrs.demo.driver.Gender;
import com.dmrs.demo.vehicle.OEM;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String phone;
    private String email;
    private String password;
    private String jobTitle;
    private String imgUrl;
    private int age;

    //Vehicle
    private String name;
    private String serialNumber;
    private String licensePlate;
    private int creationYear;
    private OEM oem;
    private String model;
}