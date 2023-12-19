package com.dmrs.demo.vehicle;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VehicleRepository extends MongoRepository<Vehicle,String> {
    void deleteVehicleBySerialNumber(String serialNumber);

    Optional<Vehicle> findBySerialNumber(String serialNumber);
    


}
