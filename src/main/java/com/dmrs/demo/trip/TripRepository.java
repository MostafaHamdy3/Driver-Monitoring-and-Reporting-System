package com.dmrs.demo.trip;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TripRepository extends MongoRepository<Trip,String> {
    void deleteTripById(String id);

    List<Trip> findAllBySerialNumber();

}
