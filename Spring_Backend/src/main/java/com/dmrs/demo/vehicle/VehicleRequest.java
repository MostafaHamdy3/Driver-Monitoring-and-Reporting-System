package com.dmrs.demo.vehicle;

import com.dmrs.demo.driver.Driver;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class VehicleRequest {
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
}
