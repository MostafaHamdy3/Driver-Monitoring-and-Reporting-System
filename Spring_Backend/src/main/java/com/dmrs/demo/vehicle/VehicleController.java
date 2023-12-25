package com.dmrs.demo.vehicle;

import com.dmrs.demo.Auth.dto.VehicleDTO;
import com.dmrs.demo.Auth.dto.VehicleRequest;
import com.dmrs.demo.DmrsApplication;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/vehicle")
@AllArgsConstructor
public class VehicleController {
  VehicleService vehicleService;


  @GetMapping
  public VehicleDTO getVehicleByDriverId(@RequestParam String id){

    Vehicle vehicle = vehicleService.getVehicleByDriverId(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));

    return VehicleDTO.builder()
            .id(vehicle.getId())
            .serialNumber(vehicle.getSerialNumber())
            .name(vehicle.getName())
            .licensePlate(vehicle.getLicensePlate())
            .creationYear(vehicle.getCreationYear())
            .oem(vehicle.getOem())
            .model(vehicle.getModel())
            .build();
  }


  @PutMapping
  public void updateVehicleById(@RequestBody VehicleRequest vehicleRequest){
    vehicleService.updateVehicle(vehicleRequest);
  }
}
