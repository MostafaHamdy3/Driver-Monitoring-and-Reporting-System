package com.dmrs.demo.vehicle;

import com.dmrs.demo.driver.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface VehicleRepository extends MongoRepository<Vehicle,String> {
    void deleteVehicleBySerialNumber(String serialNumber);

    Optional<Vehicle> findBySerialNumber(String serialNumber);


    Optional<Vehicle> findByDriver(Driver driver);


}
