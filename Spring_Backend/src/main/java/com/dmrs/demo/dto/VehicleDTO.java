package com.dmrs.demo.dto;

import com.dmrs.demo.vehicle.OEM;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class VehicleDTO{
    private String id;
    private String serialNumber;
    private String name;
    private String licensePlate;
    private int creationYear;
    private OEM oem;
    private String model;

    public VehicleDTO() {
    }
}

//public record VehicleDTO(
//
//  String id,
//  String serialNumber,
//  String name,
//  String licensePlate,
//  int creationYear,
//  OEM oem,
//  String model) {
//
//}
