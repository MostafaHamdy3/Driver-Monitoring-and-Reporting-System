package com.dmrs.demo.trip;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TripService {
    private final TripRepository tripRepo;

    public void addTrip(Trip trip){tripRepo.save(trip);}
    public void deleteTrip(String id){tripRepo.deleteTripById(id);}
    public Optional<Trip> getTrip(String id){return tripRepo.findById(id);}
    public void deleteAllTrips(){tripRepo.deleteAll();}
    public List<Trip> getAllTripsBySerialNumber(String serialNumber){return tripRepo.findAllBySerialNumber();}
    public List<Trip> getAllTrips(){return tripRepo.findAll();}


}
