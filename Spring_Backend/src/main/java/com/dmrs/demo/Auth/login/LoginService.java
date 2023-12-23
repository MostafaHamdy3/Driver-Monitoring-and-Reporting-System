package com.dmrs.demo.Auth.login;


import com.dmrs.demo.Auth.registration.EmailValidator;
import com.dmrs.demo.Auth.registration.token.ConfirmationToken;
import com.dmrs.demo.Auth.registration.token.ConfirmationTokenService;
import com.dmrs.demo.driver.Driver;
import com.dmrs.demo.driver.DriverService;
import com.dmrs.demo.exception.ApiRequestException;
import com.dmrs.demo.exception.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public record LoginService(DriverService driverService,
                           EmailValidator emailValidator,
                           BCryptPasswordEncoder bCryptPasswordEncoder,
                           ConfirmationTokenService confirmationTokenService) {
    public ResponseEntity<?> login(LoginRequest request) throws ApiRequestException {

        ResponseEntity<?> responseEntity;

        boolean isValidEmail = emailValidator.
                test(request.getEmail());

        if (!isValidEmail) {
          throw new ApiRequestException("email not valid");
        } else {

            Driver driver = driverService.getDriverByEmail(request.getEmail()).orElseThrow(() ->
                    new ApiRequestException("email not Found"));

            if (!bCryptPasswordEncoder.matches(request.getPassword(), driver.getPassword())) {
              throw new ApiRequestException("Wrong Password", ErrorCode.INVALID_PASSWORD);
            } else {
              Optional<ConfirmationToken> confirmationToken = confirmationTokenService.getTokenByDriver(driver);
              responseEntity = ResponseEntity.ok().body(confirmationToken.get());
            }
        }
        return responseEntity;
    }

}
