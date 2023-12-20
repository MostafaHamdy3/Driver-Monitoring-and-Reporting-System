package com.dmrs.demo.vehicle;

import com.dmrs.demo.DmrsApplication;
import com.dmrs.demo.driver.DriverService;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/vehicle")
@AllArgsConstructor
public class VehicleController {
  VehicleService vehicleService;

  @CrossOrigin(origins = DmrsApplication.crossOriginLink)
  @GetMapping
  public Optional<Vehicle> getVehicleByDriverId(String id){return vehicleService.getVehicleByDriverId(id);}

  @CrossOrigin(origins = DmrsApplication.crossOriginLink)
  @PutMapping
  public void updateVehicleById(Vehicle vehicle){
    vehicleService.updateVehicle(vehicle);
  }
}
