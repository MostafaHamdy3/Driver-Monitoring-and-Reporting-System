package com.dmrs.demo.RTVehicleData;

import com.mongodb.BSONTimestampCodec;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public record RTVehicleDataService(RTVehicleDataRepository vehicleDataRepo) {

    public Optional<RTVehicleData> getVehicleDataByTimestamp(BSONTimestampCodec timestamp) {
      return vehicleDataRepo.findVehicleDataByTimestamp(timestamp);
    }

  public void addVehicleData(RTVehicleData RTVehicleData) {
    vehicleDataRepo.save(RTVehicleData);
  }

  public void deleteVehicleData(String serialNumber) {
    vehicleDataRepo.deleteVehicleDataBySerialNumber(serialNumber);
  }

  public void deleteAllVehicleData() {
    vehicleDataRepo.deleteAll();
  }

  public Iterable<RTVehicleData> getAllVehicleData() {
    return vehicleDataRepo.findAll();
  }
}
