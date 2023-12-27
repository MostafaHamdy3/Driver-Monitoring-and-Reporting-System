package com.dmrs.demo.RTVehicleData.conditions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Conditions {
  private DriverBehaviour driverBehaviour;
  private RoadRule roadRules[];
  private int speedLimit;
  private int speed;
}
