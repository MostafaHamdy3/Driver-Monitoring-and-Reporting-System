package com.dmrs.demo.analysis.totalEvents;

import com.dmrs.demo.dto.TotalEventsDTO;
import com.dmrs.demo.exception.ApiRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TotalEventsService {
    private final TotalEventsRepository totalEventsRepository;

    public void save(String driverId , TotalEventsDTO totalEventsRequest) {


        TotalEvents totalEvents = TotalEvents.builder()
                .driverId(driverId)
                .suddenBraking(totalEventsRequest.getSuddenBraking())
                .swerve(totalEventsRequest.getSwerve())
                .aggTL(totalEventsRequest.getAggTL())
                .aggTR(totalEventsRequest.getAggTR())
                .speedLimitViolation(totalEventsRequest.getSpeedLimitViolation())
                .otherTrafficViolation(totalEventsRequest.getOtherTrafficViolation())
                .normal(totalEventsRequest.getNormal())
                .totalScore(totalEventsRequest.getTotalScore())
                .build();
        totalEventsRepository.save(totalEvents);
    }

    public TotalEventsDTO getTotalEvents(String driverId) {
      try {
        TotalEvents totalEvents = totalEventsRepository.findByDriverId(driverId);
        return TotalEventsDTO.builder()
                .suddenBraking(totalEvents.getSuddenBraking())
                .swerve(totalEvents.getSwerve())
                .aggTL(totalEvents.getAggTL())
                .aggTR(totalEvents.getAggTR())
                .speedLimitViolation(totalEvents.getSpeedLimitViolation())
                .otherTrafficViolation(totalEvents.getOtherTrafficViolation())
                .normal(totalEvents.getNormal())
                .totalScore(totalEvents.getTotalScore())
                .build();
      } catch (Exception e) {

        throw new ApiRequestException(e.getMessage());
      }

    }

    //todo: add update method that will increment the total events by the new events
}
