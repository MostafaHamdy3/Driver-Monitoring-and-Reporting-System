package com.dmrs.demo.Auth.authentication;

import com.dmrs.demo.Auth.security.utils.EmailValidator;
import com.dmrs.demo.driver.Gender;
import com.dmrs.demo.exception.ApiRequestException;
import com.dmrs.demo.exception.ErrorCode;
import com.dmrs.demo.vehicle.OEM;

public record RegistrationDTO(
        String firstName,
        String lastName,
        Gender gender,
        String phone,
        String username,
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

    private static final EmailValidator emailValidator = new EmailValidator();

    public RegistrationDTO {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }else {
            boolean isValidEmail = emailValidator.
                    test(username);

            if (!isValidEmail) {
                throw new ApiRequestException("username not valid", ErrorCode.EMAIL_NOT_VALID);
            }
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        if (serialNumber == null || serialNumber.isBlank()) {
            throw new IllegalArgumentException("Serial Number cannot be null or empty");
        }
    }
}




//        (String username, String password) {
//    public RegistrationDTO {
//        if (username == null || username.isBlank()) {
//            throw new IllegalArgumentException("Username cannot be null or empty");
//        }
//        if (password == null || password.isBlank()) {
//            throw new IllegalArgumentException("Password cannot be null or empty");
//        }
//    }
//}
