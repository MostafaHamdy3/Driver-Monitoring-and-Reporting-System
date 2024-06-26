package com.dmrs.demo.analysis.totalEvents;

import com.dmrs.demo.dto.TotalEventsDTO;
import com.dmrs.demo.exception.ApiRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class TotalEventsService {
    private final TotalEventsRepository totalEventsRepository;

    public void save(String driverId , TotalEventsDTO totalEventsRequest) {

        TotalEvents oldtotalEvents= totalEventsRepository.findByDriverId(driverId);



        if (oldtotalEvents == null) {
            oldtotalEvents = TotalEvents.builder()
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

            totalEventsRepository.save(oldtotalEvents);

        }
        else {

            TotalEvents totalEvents = TotalEvents.builder()
                    .id(oldtotalEvents.getId())
                    .driverId(driverId)
                    .suddenBraking((totalEventsRequest.getSuddenBraking() + oldtotalEvents.getSuddenBraking()) / 2)
                    .swerve((totalEventsRequest.getSwerve() + oldtotalEvents.getSwerve()) / 2)
                    .aggTL((totalEventsRequest.getAggTL() + oldtotalEvents.getAggTL()) / 2)
                    .aggTR((totalEventsRequest.getAggTR() + oldtotalEvents.getAggTR()) / 2)
                    .speedLimitViolation((totalEventsRequest.getSpeedLimitViolation() + oldtotalEvents.getSpeedLimitViolation()) / 2)
                    .otherTrafficViolation((totalEventsRequest.getOtherTrafficViolation() + oldtotalEvents.getOtherTrafficViolation()) / 2)
                    .normal((totalEventsRequest.getNormal() + oldtotalEvents.getNormal()) / 2)
                    .totalScore((totalEventsRequest.getTotalScore() + oldtotalEvents.getTotalScore()) / 2)
                    .build();

            totalEventsRepository.save(totalEvents);

        }
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
