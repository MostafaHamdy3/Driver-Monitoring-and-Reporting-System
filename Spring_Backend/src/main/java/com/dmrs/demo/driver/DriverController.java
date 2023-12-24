package com.dmrs.demo.driver;

import com.dmrs.demo.Auth.dto.DriverDTO;
import com.dmrs.demo.Auth.dto.DriverRequest;
import com.dmrs.demo.DmrsApplication;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/driver")
@AllArgsConstructor
public class DriverController {
    private final DriverService driverService;

    @CrossOrigin(origins = DmrsApplication.crossOriginLink)
    @GetMapping
    public DriverDTO getDriverByToken(@RequestParam String token){
        return driverService.getDriverByToken(token); // TODO: change the exception and return a proper response
    }

    @CrossOrigin(origins = DmrsApplication.crossOriginLink)
    @PutMapping
    public void updateDriver(@RequestBody DriverRequest driverRequest){driverService.updateDriver(driverRequest);}
}
