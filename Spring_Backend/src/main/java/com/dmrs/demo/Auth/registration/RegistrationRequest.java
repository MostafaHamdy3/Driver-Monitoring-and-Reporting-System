package com.dmrs.demo.Auth.registration;

import com.dmrs.demo.driver.Gender;
import com.dmrs.demo.vehicle.OEM;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


public record RegistrationRequest (
    String firstName,
    String lastName,
    Gender gender,
    String phone,
    String email,
    String password,
    String jobTitle,
    String imgUrl,
    int age,

    //Vehicle
    String name,
    String serialNumber,
    String licensePlate,
    int creationYear,
    OEM oem,
    String model
) {
}
