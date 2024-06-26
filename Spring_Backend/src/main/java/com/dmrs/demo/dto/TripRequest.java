package com.dmrs.demo.dto;


import com.dmrs.demo.trip.Status;

public record TripRequest (
    String start_time,
   String end_time,
   int suddenBraking,
   int suddenAcceleration,
   int aggTL,
    int aggTR,
    int speedLimitViolation,
   int normalDriving,

   int totalScore,
   String serialNumber,
   int distance ,
   Status status
){}
