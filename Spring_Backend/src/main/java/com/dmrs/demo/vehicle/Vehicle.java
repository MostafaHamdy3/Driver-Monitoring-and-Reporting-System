package com.dmrs.demo.vehicle;

import com.dmrs.demo.driver.Driver;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Vehicle {
    @Id
    private String id;
    private String name;
    @DocumentReference
    private Driver driver;
    @Indexed(unique = true)
    private String serialNumber;
    private String licensePlate;
    private int creationYear;
    private OEM oem;
    private String model;

    public Vehicle(String name, Driver driver, String serialNumber) {
        this.name = name;
        this.driver = driver;
        this.serialNumber = serialNumber;
    }

    public Vehicle(Driver driver, String serialNumber) {
        this.driver = driver;
        this.serialNumber = serialNumber;
    }

    public Vehicle(String name, Driver driver, String serialNumber, String licensePlate, int creationYear, OEM oem, String model) {
        this.name = name;
        this.driver = driver;
        this.serialNumber = serialNumber;
        this.licensePlate = licensePlate;
        this.creationYear = creationYear;
        this.oem = oem;
        this.model = model;
    }

}
