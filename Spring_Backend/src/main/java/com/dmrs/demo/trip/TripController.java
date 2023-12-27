package com.dmrs.demo.trip;

import com.dmrs.demo.dto.TripRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/trips")
@AllArgsConstructor
public class TripController {

  TripService tripService;

  @PostMapping
  public void addTrip(@RequestBody TripRequest trip) {
    tripService.addTrip(trip);
  }

  @GetMapping
  public Page<Trip> getTrips(@RequestParam int pageNumber, @RequestParam int pageSize , @RequestParam String serialNumber) {
    return tripService.getTripsBySerialNumber(pageNumber, pageSize , serialNumber);
  }
}
