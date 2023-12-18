package com.dmrs.demo.vehicleData;

import com.mongodb.BSONTimestampCodec;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class VehicleDataService {

    private final VehicleDataRepository vehicleDataRepo;

    public Optional<VehicleData> getVehicleDataByTimestamp(BSONTimestampCodec timestamp){return vehicleDataRepo.findVehicleDataByTimestamp(timestamp);}
    public void addVehicleData(VehicleData vehicleData){vehicleDataRepo.save(vehicleData);}
    public void deleteVehicleData(String serialNumber){vehicleDataRepo.deleteVehicleDataBySerialNumber(serialNumber);}
    public void deleteAllVehicleData(){vehicleDataRepo.deleteAll();}
    public Iterable<VehicleData> getAllVehicleData(){return vehicleDataRepo.findAll();}
}
