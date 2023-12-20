package com.dmrs.demo.vehicle;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface VehicleRepository extends MongoRepository<Vehicle,String> {
    void deleteVehicleBySerialNumber(String serialNumber);

    Optional<Vehicle> findBySerialNumber(String serialNumber);

    @Query("{ 'driver' : ?0 }")
    Optional<Vehicle> findByDriverId(String driverId);

    void updateById(String id);
}
