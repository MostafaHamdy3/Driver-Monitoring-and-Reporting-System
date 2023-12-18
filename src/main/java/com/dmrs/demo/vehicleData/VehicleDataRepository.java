package com.dmrs.demo.vehicleData;

import com.mongodb.BSONTimestampCodec;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VehicleDataRepository extends MongoRepository<VehicleData,String> {
    void deleteVehicleDataBySerialNumber(String serialNumber);

//    Iterable<VehicleData> findAllByDriverEmail(String email);

    Optional<VehicleData> findVehicleDataByTimestamp(BSONTimestampCodec timestamp);


}
