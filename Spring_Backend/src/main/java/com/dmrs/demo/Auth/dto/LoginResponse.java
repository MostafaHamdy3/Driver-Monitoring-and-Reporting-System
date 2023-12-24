package com.dmrs.demo.Auth.dto;

public record LoginResponse (
        String token,
        String driverId,
        String vehicleSerialNumber
){
}
