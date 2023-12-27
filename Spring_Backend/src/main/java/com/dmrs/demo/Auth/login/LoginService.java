package com.dmrs.demo.Auth.login;


import com.dmrs.demo.dto.LoginResponse;
import com.dmrs.demo.Auth.registration.EmailValidator;
import com.dmrs.demo.Auth.registration.token.ConfirmationToken;
import com.dmrs.demo.Auth.registration.token.ConfirmationTokenService;
import com.dmrs.demo.driver.Driver;
import com.dmrs.demo.driver.DriverService;
import com.dmrs.demo.exception.ApiRequestException;
import com.dmrs.demo.exception.ErrorCode;
import com.dmrs.demo.vehicle.Vehicle;
import com.dmrs.demo.vehicle.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public record LoginService(DriverService driverService,
                           EmailValidator emailValidator,
                           BCryptPasswordEncoder bCryptPasswordEncoder,
                           ConfirmationTokenService confirmationTokenService,
                           VehicleService vehicleService) {

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
              Vehicle vehicle = vehicleService.getVehicleByDriverId(driver.getId()).orElseThrow(() ->
                      new ApiRequestException("Vehicle not Found"));
              LoginResponse loginResponse = new LoginResponse(confirmationToken.get().getToken(), driver.getId(), vehicle.getSerialNumber());
              responseEntity = ResponseEntity.ok().body(loginResponse);
            }
        }
        return responseEntity;
    }

}
