package com.dmrs.demo.dto;

public record LoginResponse (
        String token,
        String driverId,
        String vehicleSerialNumber
){
}
