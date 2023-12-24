package com.dmrs.demo.Auth.dto;

import com.dmrs.demo.RTVehicleData.Status;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.ZonedDateTime;



public record TripRequest (
   String serialNumber,
   String start_timestamp,
   String end_timestamp,
   int distance ,
   Status status
){}
