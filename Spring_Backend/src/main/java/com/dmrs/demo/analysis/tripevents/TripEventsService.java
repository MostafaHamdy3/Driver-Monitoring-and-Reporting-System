package com.dmrs.demo.analysis.tripevents;

import com.dmrs.demo.dto.TripEventsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripEventsService {
  private final TripEventsRepository tripEventsRepository;

  public void saveTripEvents( String tripId , TripEventsDTO tripEventsDTO) {

    TripEvents tripEvents = TripEvents.builder()
      .tripId(tripId)
      .suddenBraking(tripEventsDTO.getSuddenBraking())
      .swerve(tripEventsDTO.getSwerve())
      .aggTL(tripEventsDTO.getAggTL())
      .aggTR(tripEventsDTO.getAggTR())
      .speedLimitViolation(tripEventsDTO.getSpeedLimitViolation())
      .otherTrafficViolation(tripEventsDTO.getOtherTrafficViolation())
      .normal(tripEventsDTO.getNormal())
      .totalScore(tripEventsDTO.getTotalScore())
      .build();

    tripEventsRepository.save(tripEvents);
  }

  public TripEventsDTO getTripEventsDTO(String tripId) {
    TripEvents tripEvents = tripEventsRepository.findByTripId(tripId).orElseThrow();
    return TripEventsDTO.builder()
      .suddenBraking(tripEvents.getSuddenBraking())
      .swerve(tripEvents.getSwerve())
      .aggTL(tripEvents.getAggTL())
      .aggTR(tripEvents.getAggTR())
      .speedLimitViolation(tripEvents.getSpeedLimitViolation())
      .otherTrafficViolation(tripEvents.getOtherTrafficViolation())
      .normal(tripEvents.getNormal())
      .totalScore(tripEvents.getTotalScore())
      .build();
  }
}
