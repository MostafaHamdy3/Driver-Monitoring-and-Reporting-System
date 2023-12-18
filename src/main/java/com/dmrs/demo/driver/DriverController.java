package com.dmrs.demo.driver;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/driver")
@AllArgsConstructor
public class DriverController {
    private final DriverService driverService;

    record NewDoctorRequest(
             String firstName,
             String lastName,
             Gender gender,
             String phone,
             String email,
             String password
             ){}

    @PostMapping
    public void addDriver(@RequestBody NewDoctorRequest request){
        Driver driver = new Driver(request.firstName(),
                request.lastName(),
                request.gender(),
                request.phone(),
                request.email(),
                request.password());

        System.out.println(request);
        driverService.addDriver(driver);
    }

    @GetMapping
    public Driver getDriverByMail(@RequestParam String email){
        return driverService.getDriverByEmail(email).orElseThrow();
    }
}
