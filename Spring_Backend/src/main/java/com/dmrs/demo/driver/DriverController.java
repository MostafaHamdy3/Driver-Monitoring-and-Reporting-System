package com.dmrs.demo.driver;

import com.dmrs.demo.dto.DriverDTO;
import com.dmrs.demo.dto.DriverRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/driver")
@AllArgsConstructor
public class DriverController {
    private final DriverService driverService;


    @GetMapping
    public DriverDTO getDriverById(@RequestParam String id){
        Driver driver = driverService.getDriverById(id);
        return new DriverDTO(driver.getId(), driver.getFirstName(), driver.getLastName(), driver.getUser().getUsername(), driver.getGender(), driver.getAge(), driver.getPhone(), driver.getJobTitle(), driver.getImgUrl());
    }


    @PutMapping
    public void updateDriver(@RequestBody DriverRequest driverRequest){driverService.updateDriver(driverRequest);}
}
