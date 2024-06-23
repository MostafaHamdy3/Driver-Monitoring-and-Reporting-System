package com.dmrs.demo.driver;

import com.dmrs.demo.dto.DriverDTO;
import com.dmrs.demo.dto.DriverRequest;
import com.dmrs.demo.Auth.registration.token.ConfirmationToken;
import com.dmrs.demo.Auth.registration.token.ConfirmationTokenService;
import com.dmrs.demo.exception.ApiRequestException;
import com.dmrs.demo.exception.ErrorCode;
import com.dmrs.demo.vehicle.Vehicle;
import com.dmrs.demo.vehicle.VehicleRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Optional;

@Service
public record DriverService(DriverRepository driverRepo,
                            VehicleRepository vehicleRepo,
                            BCryptPasswordEncoder bCryptPasswordEncoder,
                            ConfirmationTokenService confirmationTokenService) implements UserDetailsService {
    // TODO: Create a class for User messages
    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

  public Optional<Driver> getDriverByEmail(String email) {
    return driverRepo.findByEmail(email);
  }

  public void addDriver(Driver driver) {
    driverRepo.update(driver);
  }

  public void deleteDriver(String email) {
    driverRepo.deleteDriverByEmail(email);
  }

    public Iterable<Driver> getAllDrivers() {
      return driverRepo.findAll();
    }

    public void updateDriver(DriverRequest driverRequest) {

      Driver oldDriver = driverRepo.findById(driverRequest.getId()).orElseThrow(() ->
              new ApiRequestException("Driver not Found"));

      Driver driver = new Driver();
      driver.setId(driverRequest.getId());

      if (driverRequest.getFirstName() == null) driver.setFirstName(oldDriver.getFirstName());
      else driver.setFirstName(driverRequest.getFirstName());
      if (driverRequest.getLastName() == null) driver.setLastName(oldDriver.getLastName());
      else driver.setLastName(driverRequest.getLastName());
      if (driverRequest.getEmail() == null) driver.setEmail(oldDriver.getEmail()); // TODO: check if email is already taken
      else driver.setEmail(driverRequest.getEmail());


      driver.setPassword(oldDriver.getPassword());

      if (driverRequest.getPhone() == null) driver.setPhone(oldDriver.getPhone());
      else driver.setPhone(driverRequest.getPhone());
      if (driverRequest.getGender() == null) driver.setGender(oldDriver.getGender());
      else driver.setGender(driverRequest.getGender());
      if (driverRequest.getJobTitle() == null) driver.setJobTitle(oldDriver.getJobTitle());
      else  driver.setJobTitle(driverRequest.getJobTitle());
      if (driverRequest.getImgUrl() == null) driver.setImgUrl(oldDriver.getImgUrl());
      else driver.setImgUrl(driverRequest.getImgUrl());
      if (driverRequest.getAge() == 0) driver.setAge(oldDriver.getAge());
      else driver.setAge(driverRequest.getAge());
      if (driverRequest.getScore() == 0) driver.setScore(oldDriver.getScore());
      else driver.setScore(driverRequest.getScore());


      driverRepo.save(driver);
    }

  @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return driverRepo.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }


    public String signUpUser(Driver driver, Vehicle vehicle) {

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

            throw new ApiRequestException("email already taken or Vehicle Serial Number is already taken", ErrorCode.EMAIL_ALREADY_TAKEN);
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

        driverRepo.updateEnabledByEmail(email, true);

    }

  public DriverDTO getDriverByToken(String token) {
    Optional<ConfirmationToken> confirmationToken = confirmationTokenService.getToken(token);
    Optional<Driver> driver = Optional.empty();
    if (confirmationToken.isPresent()) {
      driver = Optional.ofNullable(confirmationToken.get().getDriver());
    } else {
      // TODO: throw an exception
    }

    DriverDTO driverDTO = new DriverDTO(driver.get().getId(), driver.get().getFirstName(), driver.get().getLastName(), driver.get().getEmail(), driver.get().getGender(), driver.get().getAge(), driver.get().getPhone(), driver.get().getJobTitle(), driver.get().getImgUrl());


    return driverDTO;

  }

  public Driver getDriverById(String driverId) {

    return driverRepo.findById(driverId).orElseThrow();
  }
}
