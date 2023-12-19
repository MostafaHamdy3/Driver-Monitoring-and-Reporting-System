package com.dmrs.demo.RTVehicleData;

import com.mongodb.BSONTimestampCodec;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RTVehicleDataRepository extends MongoRepository<RTVehicleData,String> {
    void deleteVehicleDataBySerialNumber(String serialNumber);

//    Iterable<VehicleData> findAllByDriverEmail(String email);

    Optional<RTVehicleData> findVehicleDataByTimestamp(BSONTimestampCodec timestamp);


}
