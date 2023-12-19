package com.dmrs.demo.driver;

import com.dmrs.demo.Auth.registration.token.ConfirmationToken;
import com.dmrs.demo.Auth.registration.token.ConfirmationTokenService;
import com.dmrs.demo.vehicle.Vehicle;
import com.dmrs.demo.vehicle.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import java.util.Optional;

@AllArgsConstructor
@Service
public class DriverService  implements UserDetailsService{
    private final DriverRepository driverRepo;
    private final VehicleRepository vehicleRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    // TODO: Create a class for User messages
    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";
    private final ConfirmationTokenService confirmationTokenService;

    public Optional<Driver> getDriverByEmail(String email){return driverRepo.findByEmail(email);}
    public void addDriver(Driver driver){driverRepo.save(driver);}
    public void deleteDriver(String email){driverRepo.deleteDriverByEmail(email);}
    public void updateDriver(Driver driver){driverRepo.save(driver);}
    public Iterable<Driver> getAllDrivers(){return driverRepo.findAll();}


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return driverRepo.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }


    public String signUpUser(Driver driver , Vehicle vehicle) {

        // TODO: remove the signup logic from here and put it in the RegistrationService
        boolean userExists = driverRepo
                .findByEmail(driver.getEmail())
                .isPresent();

        boolean vehicleExists = vehicleRepo
                .findBySerialNumber(vehicle.getSerialNumber())
                .isPresent();

        if (userExists || vehicleExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(driver.getPassword());

        driver.setPassword(encodedPassword);

        driverRepo.save(driver);
        vehicleRepo.save(vehicle);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                driver
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken);

        return token;
    }

    public void enableAppUser(String email) {
//        return driverRepo.findByEmail(email)
//                .map(driver -> {
//                    driver.setEnabled(true);
//                    return 1;
//                })
//                .orElseThrow(() ->
//                        new UsernameNotFoundException(
//                                String.format(USER_NOT_FOUND_MSG, email)));

        driverRepo.updateEnabledByEmail(email,true);

    }
}
