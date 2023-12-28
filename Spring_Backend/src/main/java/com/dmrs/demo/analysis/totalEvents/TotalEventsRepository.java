package com.dmrs.demo.analysis.totalEvents;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalEventsRepository extends MongoRepository<TotalEvents,String> {
  // todo: change the return type to Optional
  TotalEvents findByDriverId(String driverId);
}
