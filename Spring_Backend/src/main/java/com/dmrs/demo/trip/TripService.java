package com.dmrs.demo.trip;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TripService {
    private final TripRepository tripRepo;

    public void addTrip(TripRequest tripRequest){
      Trip trip = new Trip();
      trip.setSerialNumber(tripRequest.getSerialNumber());
      trip.setStart_timestamp(tripRequest.getStart_timestamp());
      trip.setEnd_timestamp(tripRequest.getEnd_timestamp());
      trip.setDistance(tripRequest.getDistance());
      trip.setStatus(tripRequest.getStatus());
      tripRepo.save(trip);
    }
    public void deleteTrip(String id){tripRepo.deleteTripById(id);}
    public Optional<Trip> getTrip(String id){return tripRepo.findById(id);}
    public void deleteAllTrips(){tripRepo.deleteAll();}
    public List<Trip> getAllTripsBySerialNumber(String serialNumber){return tripRepo.findAllBySerialNumber(serialNumber);}
    public List<Trip> getAllTrips(){return tripRepo.findAll();}
  public Page<Trip> getTripsBySerialNumber(int pageNumber, int pageSize , String serialNumber) {
    Pageable pageable = PageRequest.of(pageNumber, pageSize);
    return tripRepo.findBySerialNumber(serialNumber,pageable);
  }


}
