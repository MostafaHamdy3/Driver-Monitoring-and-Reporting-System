package com.dmrs.demo.trip;


import com.dmrs.demo.dto.TripRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;



@Service
public record TripService(TripRepository tripRepo) {


  public void addTrip(TripRequest tripRequest) {
      Trip trip = new Trip();
      trip.setSerialNumber(tripRequest.serialNumber());
      trip.setStart_timestamp(tripRequest.start_timestamp());
      trip.setEnd_timestamp(tripRequest.end_timestamp());
      trip.setDistance(tripRequest.distance());
      trip.setStatus(tripRequest.status());
      tripRepo.save(trip);
    }

  public void deleteTrip(String id) {
    tripRepo.deleteTripById(id);
  }

  public Optional<Trip> getTrip(String id) {
    return tripRepo.findById(id);
  }

  public void deleteAllTrips() {
    tripRepo.deleteAll();
  }

  public List<Trip> getAllTripsBySerialNumber(String serialNumber) {
    return tripRepo.findAllBySerialNumber(serialNumber);
  }

  public List<Trip> getAllTrips() {
    return tripRepo.findAll();
  }

  public Page<Trip> getTripsBySerialNumber(int pageNumber, int pageSize, String serialNumber) {
    Pageable pageable = PageRequest.of(pageNumber, pageSize);
    return tripRepo.findBySerialNumber(serialNumber, pageable);
  }


}
