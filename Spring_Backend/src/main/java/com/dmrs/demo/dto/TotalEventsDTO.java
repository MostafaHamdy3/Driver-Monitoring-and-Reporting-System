package com.dmrs.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TotalEventsDTO {

  private int suddenBraking;
  private int swerve;
  private int aggTL;
  private int aggTR;
  private int speedLimitViolation;
  private int otherTrafficViolation;
  private int normal;
  private int totalScore;


}
