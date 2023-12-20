package com.dmrs.demo.Auth.login;


import com.dmrs.demo.Auth.registration.EmailValidator;
import com.dmrs.demo.Auth.registration.token.ConfirmationToken;
import com.dmrs.demo.Auth.registration.token.ConfirmationTokenService;
import com.dmrs.demo.driver.Driver;
import com.dmrs.demo.driver.DriverService;
import com.dmrs.demo.vehicle.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginService {
    private final DriverService driverService;
    private final EmailValidator emailValidator;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    public ResponseEntity<?> login(LoginRequest request) {

        ResponseEntity<?> responseEntity ;

        boolean isValidEmail = emailValidator.
                test(request.getEmail());

        if (!isValidEmail) {
            responseEntity = ResponseEntity.badRequest().body("email not valid");
        } else {

            Optional<Driver> driver = driverService.getDriverByEmail(request.getEmail());
            if (driver.isEmpty()) {
                responseEntity = ResponseEntity.badRequest().body("email not found");
            }

            else if (!bCryptPasswordEncoder.matches(request.getPassword(), driver.get().getPassword())) {
                responseEntity = ResponseEntity.badRequest().body("password not match");
            }
            else {
              System.out.println(request);
              System.out.println(driver.get());
              Optional<ConfirmationToken> confirmationToken = confirmationTokenService.getTokenByDriver(driver.get());
              System.out.println(confirmationToken.get());
              responseEntity = ResponseEntity.ok().body(confirmationToken.get());
            }
        }
        return responseEntity;
    }

}
