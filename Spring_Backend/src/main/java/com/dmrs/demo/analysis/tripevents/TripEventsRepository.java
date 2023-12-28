package com.dmrs.demo.analysis.tripevents;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TripEventsRepository extends MongoRepository<TripEvents,String> {
  Optional<TripEvents> findByTripId(String tripId);
}
