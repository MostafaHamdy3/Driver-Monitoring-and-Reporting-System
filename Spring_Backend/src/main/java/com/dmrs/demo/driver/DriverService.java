package com.dmrs.demo.driver;

import com.dmrs.demo.Auth.user.UserService;
import com.dmrs.demo.dto.DriverDTO;
import com.dmrs.demo.dto.DriverRequest;

import com.dmrs.demo.exception.ApiRequestException;
import com.dmrs.demo.vehicle.VehicleRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public record DriverService(DriverRepository driverRepo,
                            UserService userService)  {
    // TODO: Create a class for User messages
    private final static String USER_NOT_FOUND_MSG =
            "user with username %s not found";

//  public Optional<Driver> getDriverByEmail(String username) {
//    return driverRepo.findByEmail(username);
//  }

  public Driver addDriver(Driver driver) {
    return driverRepo.save(driver);
  }

//  public void deleteDriver(String username) {
//    driverRepo.deleteDriverByEmail(username);
//  }

    public Iterable<Driver> getAllDrivers() {
      return driverRepo.findAll();
    }

    public void updateDriver(DriverRequest driverRequest) {

      Driver oldDriver = driverRepo.findById(driverRequest.getId()).orElseThrow(() ->
              new ApiRequestException("Driver not Found"));

      Driver driver = new Driver();
      driver.setId(driverRequest.getId());
      driver.setUser(oldDriver.getUser());

      if (driverRequest.getFirstName() == null) driver.setFirstName(oldDriver.getFirstName());
      else driver.setFirstName(driverRequest.getFirstName());
      if (driverRequest.getLastName() == null) driver.setLastName(oldDriver.getLastName());
      else driver.setLastName(driverRequest.getLastName());
//      if (driverRequest.getEmail() == null) driver.setEmail(oldDriver.getEmail()); // TODO: check if username is already taken
//      else driver.setEmail(driverRequest.getEmail());
//
//
//      driver.setPassword(oldDriver.getPassword());

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



  public Driver getDriverByUserID(String userId) {

    return driverRepo.findByUser(userService.getUserById(userId)).orElseThrow(() ->
            new ApiRequestException("Driver not Found"));
  }

  public Driver getDriverById(String id){
    return driverRepo.findById(id).orElseThrow(() ->
            new ApiRequestException("Driver not Found"));
  }
}
