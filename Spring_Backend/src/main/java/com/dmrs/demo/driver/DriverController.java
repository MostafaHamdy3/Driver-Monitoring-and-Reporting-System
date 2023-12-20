package com.dmrs.demo.driver;

import com.dmrs.demo.DmrsApplication;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/driver")
@AllArgsConstructor
public class DriverController {
    private final DriverService driverService;

    @CrossOrigin(origins = DmrsApplication.crossOriginLink)
    @GetMapping
    public Driver getDriverByToken(@RequestParam String token){
        return driverService.getDriverByToken(token).orElseThrow(); // TODO: change the exception and return a proper response
    }

    @CrossOrigin(origins = DmrsApplication.crossOriginLink)
    @PutMapping
    public void updateDriverById(String id){driverService.updateDriverById(id);}
}
