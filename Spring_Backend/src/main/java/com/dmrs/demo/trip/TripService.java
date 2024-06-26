package com.dmrs.demo.trip;


import com.dmrs.demo.analysis.totalEvents.TotalEventsService;
import com.dmrs.demo.analysis.tripevents.TripEventsService;
import com.dmrs.demo.dto.TotalEventsDTO;
import com.dmrs.demo.dto.TripEventsDTO;
import com.dmrs.demo.dto.TripRequest;
import com.dmrs.demo.vehicle.Vehicle;
import com.dmrs.demo.vehicle.VehicleService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;



@Service
public record TripService(TripRepository tripRepo, TripEventsService tripEventsService , TotalEventsService totalEventsService , VehicleService vehicleService){


  public void addTrip(TripRequest tripRequest) {
      Trip trip = new Trip();
      trip.setSerialNumber(tripRequest.serialNumber());
      trip.setStart_timestamp(tripRequest.start_time());
      trip.setEnd_timestamp(tripRequest.end_time());
      trip.setDistance(tripRequest.distance());

      if(tripRequest.totalScore() > 80) {
          trip.setStatus(Status.NORMAL);
      }else if (tripRequest.totalScore() > 60) {
          trip.setStatus(Status.AGGRESSIVE);
      }else {
          trip.setStatus(Status.VERY_AGGRESSIVE);
      }
      trip = tripRepo.save(trip);

      TripEventsDTO tripEventsDTO = new TripEventsDTO();
        tripEventsDTO.setAggAcc(tripRequest.suddenAcceleration());
        tripEventsDTO.setSuddenBraking(tripRequest.suddenBraking());
        tripEventsDTO.setAggTR(tripRequest.aggTR());
        tripEventsDTO.setAggTL(tripRequest.aggTL());
        tripEventsDTO.setSpeedLimitViolation(tripRequest.speedLimitViolation());
        tripEventsDTO.setNormal(tripRequest.normalDriving());
        tripEventsDTO.setTotalScore(tripRequest.totalScore());

      tripEventsService.saveTripEvents(trip.getId(), tripEventsDTO);

      TotalEventsDTO totalEventsDTO = TotalEventsDTO.builder()
              .suddenBraking(tripRequest.suddenBraking())
              .aggTL(tripRequest.aggTL())
              .aggTR(tripRequest.aggTR())
              .speedLimitViolation(tripRequest.speedLimitViolation())
              .normal(tripRequest.normalDriving())
              .totalScore(tripRequest.totalScore())
              .build();

      Optional<Vehicle> opVehicle = vehicleService.getVehicle(tripRequest.serialNumber());
        if(opVehicle.isPresent()){
            Vehicle vehicle = opVehicle.get();
            totalEventsService.save(vehicle.getDriver().getId(), totalEventsDTO);
        }




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
