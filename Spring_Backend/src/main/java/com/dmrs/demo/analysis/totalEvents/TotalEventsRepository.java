package com.dmrs.demo.analysis.totalEvents;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalEventsRepository extends MongoRepository<TotalEvents,String> {
  TotalEvents findByDriverId(String driverId);
}
