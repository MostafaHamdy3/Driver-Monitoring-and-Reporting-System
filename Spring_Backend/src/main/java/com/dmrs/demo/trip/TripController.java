package com.dmrs.demo.trip;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/trips")
@AllArgsConstructor
public class TripController {

  TripService tripService;

  @GetMapping("/entities")
  public Page<Trip> getEntities(@RequestParam int pageNumber, @RequestParam int pageSize , @RequestParam String serialNumber) {
    return tripService.getTripsBySerialNumber(pageNumber, pageSize , serialNumber);
  }
}
