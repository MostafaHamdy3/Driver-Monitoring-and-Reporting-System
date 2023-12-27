package com.dmrs.demo.analysis.totalEvents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
@Builder
public class TotalEvents {
  @Id
  private String id;
  @Indexed(unique = true)
  private String driverId; // todo: change to driver and make it reference
  private int suddenBraking;
  private int swerve;
  private int aggTL;
  private int aggTR;
  private int speedLimitViolation;
  private int otherTrafficViolation;
  private int normal;
  private int totalScore;
}
