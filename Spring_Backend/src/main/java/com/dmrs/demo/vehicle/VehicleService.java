package com.dmrs.demo.vehicle;

import com.dmrs.demo.dto.VehicleRequest;
import com.dmrs.demo.driver.Driver;
import com.dmrs.demo.driver.DriverService;
import com.dmrs.demo.exception.ApiRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public record VehicleService(VehicleRepository vehicleRepo,
                             DriverService driverService) {
    public void addVehicle(Vehicle vehicle) {
      vehicleRepo.save(vehicle);
    }

  public void deleteVehicle(String serialNumber) {
    vehicleRepo.deleteVehicleBySerialNumber(serialNumber);
  }

  public void deleteAllVehicles() {
    vehicleRepo.deleteAll();
  }

  public Optional<Vehicle> getVehicle(String serialNumber) {

      return vehicleRepo.findBySerialNumber(serialNumber);
  }

  public List<Vehicle> getAllVehicles() {
    return vehicleRepo.findAll();
  }

  //    public Iterable<Vehicle> getAllVehiclesByDriverEmail(String email){return vehicleRepo.findAllByDriverEmail(email);}
    public Optional<Vehicle> getVehicleByDriverId(String driverId) {
      Driver driver = driverService.getDriverById(driverId);
      return vehicleRepo.findByDriver(driver);
    }

  public void updateVehicle(VehicleRequest vehicleRequest) {
      Vehicle oldVehicle = getVehicle(vehicleRequest.getSerialNumber()).orElseThrow(()->
        new ApiRequestException("Serial Number can't be Modified or Wrong Serial Number"));

    Vehicle vehicle = new Vehicle();
    if (vehicleRequest.getId() == null) {
      vehicle.setId(oldVehicle.getId());
    } else {
      vehicle.setId(vehicleRequest.getId());
    }
    if (vehicleRequest.getSerialNumber() == null) {
      vehicle.setSerialNumber(oldVehicle.getSerialNumber());
    } else {
      vehicle.setSerialNumber(vehicleRequest.getSerialNumber());
    }
    if (vehicleRequest.getName() == null) {
      vehicle.setName(oldVehicle.getName());
    } else {
      vehicle.setName(vehicleRequest.getName());
    }

    if (vehicleRequest.getLicensePlate() == null) {
      vehicle.setLicensePlate(oldVehicle.getLicensePlate());
    } else {
      vehicle.setLicensePlate(vehicleRequest.getLicensePlate());
    }

    if (vehicleRequest.getCreationYear() == 0) {
      vehicle.setCreationYear(oldVehicle.getCreationYear());
    } else {
      vehicle.setCreationYear(vehicleRequest.getCreationYear());
    }

    if (vehicleRequest.getOem() == null) {
      vehicle.setOem(oldVehicle.getOem());
    } else {
      vehicle.setOem(vehicleRequest.getOem());
    }

    if (vehicleRequest.getModel() == null) {
      vehicle.setModel(oldVehicle.getModel());
    } else {
      vehicle.setModel(vehicleRequest.getModel());
    }

    vehicle.setDriver(getVehicle(vehicleRequest.getSerialNumber()).get().getDriver());

    vehicleRepo.save(vehicle);

  }
}
