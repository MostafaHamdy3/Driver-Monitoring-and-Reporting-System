package com.dmrs.demo.Auth.login;


import com.dmrs.demo.Auth.registration.EmailValidator;
import com.dmrs.demo.Auth.registration.token.ConfirmationToken;
import com.dmrs.demo.Auth.registration.token.ConfirmationTokenService;
import com.dmrs.demo.driver.Driver;
import com.dmrs.demo.driver.DriverService;
import com.dmrs.demo.exception.ApiRequestException;
import com.dmrs.demo.exception.ErrorCode;
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

    public ResponseEntity<?> login(LoginRequest request) throws ApiRequestException {

        ResponseEntity<?> responseEntity ;

        boolean isValidEmail = emailValidator.
                test(request.getEmail());



        if (!isValidEmail) {
//            responseEntity = ResponseEntity.badRequest().body("email not valid");
          throw new ApiRequestException("email not valid");
        } else {

            Driver driver = driverService.getDriverByEmail(request.getEmail()).orElseThrow(() ->
                    new ApiRequestException("email not Found"));
//            if (driver.isEmpty()) {
////                responseEntity = ResponseEntity.badRequest().body("email not found");
//              throw new ApiRequestException(
//                ErrorCode.EMAIL_NOT_FOUND,
//                HttpStatus.BAD_REQUEST
//              );
//            }

            if (!bCryptPasswordEncoder.matches(request.getPassword(), driver.getPassword())) {
                responseEntity = ResponseEntity.badRequest().body("password not match");
            }
            else {
              Optional<ConfirmationToken> confirmationToken = confirmationTokenService.getTokenByDriver(driver);
              responseEntity = ResponseEntity.ok().body(confirmationToken.get());
            }
        }
        return responseEntity;
    }

}
