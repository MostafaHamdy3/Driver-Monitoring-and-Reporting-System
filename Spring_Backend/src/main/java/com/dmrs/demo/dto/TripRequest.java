package com.dmrs.demo.dto;


import com.dmrs.demo.trip.Status;

public record TripRequest (
   String serialNumber,
   String start_timestamp,
   String end_timestamp,
   int distance ,
   Status status
){}
