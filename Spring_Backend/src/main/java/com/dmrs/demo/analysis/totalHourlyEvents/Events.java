package com.dmrs.demo.analysis.totalHourlyEvents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Events{
  private int aggCorneringAndBraking;
  private int swerve;
  private int trafficViolation;
}
