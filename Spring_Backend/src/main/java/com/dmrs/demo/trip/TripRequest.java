package com.dmrs.demo.trip;

import com.dmrs.demo.RTVehicleData.Status;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.ZonedDateTime;


@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class TripRequest {
  private String serialNumber;
  private ZonedDateTime start_timestamp;
  private ZonedDateTime end_timestamp;
  private int distance = 0;
  private Status status;
}
