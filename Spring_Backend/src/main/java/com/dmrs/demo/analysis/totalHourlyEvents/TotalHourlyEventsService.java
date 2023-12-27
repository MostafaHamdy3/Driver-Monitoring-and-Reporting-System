package com.dmrs.demo.analysis.totalHourlyEvents;

import com.dmrs.demo.dto.TotalHourlyEventsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TotalHourlyEventsService {
  private final TotalHourlyEventsRepository totalHourlyEventsRepository;

  public TotalHourlyEventsDTO getByDriverId(String driverId) {
    TotalHourlyEvents totalHourlyEvents = this.totalHourlyEventsRepository.findByDriverId(driverId);
    return TotalHourlyEventsDTO.builder()
        .oneToSix(totalHourlyEvents.getOneToSix())
        .sevenToTwelve(totalHourlyEvents.getSevenToTwelve())
        .thirteenToEighteen(totalHourlyEvents.getThirteenToEighteen())
        .nineteenToTwentyFour(totalHourlyEvents.getNineteenToTwentyFour())
        .build();
  }

  public void save(String driverId, TotalHourlyEventsDTO totalHourlyEventsDTO ) {
    TotalHourlyEvents totalHourlyEvents = TotalHourlyEvents.builder()
        .driverId(driverId)
        .oneToSix(totalHourlyEventsDTO.getOneToSix())
        .sevenToTwelve(totalHourlyEventsDTO.getSevenToTwelve())
        .thirteenToEighteen(totalHourlyEventsDTO.getThirteenToEighteen())
        .nineteenToTwentyFour(totalHourlyEventsDTO.getNineteenToTwentyFour())
        .build();
    this.totalHourlyEventsRepository.save(totalHourlyEvents);

  }

}
