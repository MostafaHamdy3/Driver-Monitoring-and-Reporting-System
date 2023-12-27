package com.dmrs.demo.analysis.totalHourlyEvents;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalHourlyEventsRepository extends MongoRepository<TotalHourlyEvents,String> {
  TotalHourlyEvents findByDriverId(String driverId);
}
