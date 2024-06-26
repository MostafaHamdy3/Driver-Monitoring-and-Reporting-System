package com.dmrs.demo.Auth.authentication;

import com.dmrs.demo.Auth.user.ApplicationUser;
import com.dmrs.demo.Auth.user.Role;
import com.dmrs.demo.Auth.user.RoleService;
import com.dmrs.demo.Auth.user.UserService;
import com.dmrs.demo.driver.Driver;
import com.dmrs.demo.driver.DriverService;
import com.dmrs.demo.dto.ResponsePayload;
import com.dmrs.demo.vehicle.Vehicle;
import com.dmrs.demo.vehicle.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
@Service
@Transactional
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    private final UserService userService;
    private final DriverService driverService;

    private final VehicleService vehicleService;

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    public ResponseEntity<ResponsePayload> registerUser(RegistrationDTO body) {

        String encodedPassword = passwordEncoder.encode(body.password());
        Role userRole = roleService.getRole("USER");

        Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);

        ApplicationUser user = userService.addUser(new ApplicationUser( body.username(), encodedPassword, authorities));

        Driver driver = driverService.addDriver( new Driver(
                user,
                body.firstName(),
                body.lastName(),
                body.gender(),
                body.phone(),
                body.jobTitle(),
                body.imgUrl(),
                body.age()
        ));



        vehicleService.addVehicle( new Vehicle(
                body.name(),
                driver,
                body.serialNumber(),
                body.licensePlate(),
                body.creationYear(),
                body.oem(),
                body.model()
        ));
        // TODO: add the registration confirmation logic here

//        String token = UUID.randomUUID().toString();
//
//        ConfirmationToken confirmationToken = new ConfirmationToken(
//                token,
//                LocalDateTime.now(),
//                LocalDateTime.now().plusMinutes(15),
//                driver
//        );
//
//        confirmationTokenService.saveConfirmationToken(
//                confirmationToken);
//
//
//        String link = "http://localhost:8082/api/v1/registration/confirm?token=" + token;
//        emailSender.send(
//                request.username(),
//                buildEmail(request.firstName(), link));


        ResponsePayload rp = ResponsePayload.builder()
                .code(HttpStatus.OK)
                .successMessage("User Registered successfully")
                .data(
                        null
                ).build();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        rp
                );
    }

    public ResponseEntity<ResponsePayload> loginUser(String username, String password) {
        ResponsePayload rp;
        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);
            String userId = userService.getUserByUsername(username).getId();
            String driverId = driverService.getDriverByUserID(userId).getId();
            String vehicleSerialNumber = vehicleService.getVehicleByDriverId(driverId).get().getSerialNumber();
            rp = ResponsePayload.builder()
                    .code(HttpStatus.OK)
                    .successMessage("User logged in successfully")
                    .data(
                            Map.of("driverId", driverId, "serialNumber",vehicleSerialNumber, "token", token)
                    ).build();


        } catch(AuthenticationException e){
            rp = ResponsePayload.builder()
                    .code(HttpStatus.NOT_FOUND)
                    .successMessage(e.getMessage())
                    .data(
                            null
                    ).build();

        }

        return ResponseEntity
                .status(rp.getCode())
                .body(
                        rp
                );
    }

}
