package com.dmrs.demo.RTVehicleData;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/car-data")
@AllArgsConstructor
public class RTVehicleDataController {

    private final RTVehicleDataService vehicleDataService;

}
