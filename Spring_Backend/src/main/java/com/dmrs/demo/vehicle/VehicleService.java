package com.dmrs.demo.vehicle;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepo;

    public void addVehicle(Vehicle vehicle){vehicleRepo.save(vehicle);}
    public void deleteVehicle(String serialNumber){vehicleRepo.deleteVehicleBySerialNumber(serialNumber);}
    public void deleteAllVehicles(){vehicleRepo.deleteAll();}
    public Optional<Vehicle> getVehicle(String serialNumber){return vehicleRepo.findBySerialNumber(serialNumber);}
    public List<Vehicle> getAllVehicles(){return vehicleRepo.findAll();}
//    public Iterable<Vehicle> getAllVehiclesByDriverEmail(String email){return vehicleRepo.findAllByDriverEmail(email);}
    public Optional<Vehicle> getVehicleByDriverId(String driverId){return vehicleRepo.findByDriverId(driverId);}

  public void updateVehicle(VehicleRequest vehicleRequest) {
      Vehicle vehicle = new Vehicle();
      vehicle.setId(vehicleRequest.getId());
      vehicle.setSerialNumber(vehicleRequest.getSerialNumber());
      vehicle.setName(vehicleRequest.getName());
      vehicle.setDriver(vehicleRequest.getDriver());
      vehicle.setLicensePlate(vehicleRequest.getLicensePlate());
      vehicle.setCreationYear(vehicleRequest.getCreationYear());
      vehicle.setOem(vehicleRequest.getOem());
      vehicle.setModel(vehicleRequest.getModel());


    vehicleRepo.save(vehicle);

  }
}
