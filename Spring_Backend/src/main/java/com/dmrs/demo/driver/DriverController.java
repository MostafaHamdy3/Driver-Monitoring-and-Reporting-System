package com.dmrs.demo.driver;

import com.dmrs.demo.dto.DriverDTO;
import com.dmrs.demo.dto.DriverRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/driver")
@AllArgsConstructor
public class DriverController {
    private final DriverService driverService;


    @GetMapping
    public DriverDTO getDriverByToken(@RequestParam String token){
        return driverService.getDriverByToken(token); // TODO: change the exception and return a proper response
    }


    @PutMapping
    public void updateDriver(@RequestBody DriverRequest driverRequest){driverService.updateDriver(driverRequest);}
}
