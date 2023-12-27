package com.dmrs.demo.dto;

import com.dmrs.demo.analysis.totalHourlyEvents.Events;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TotalHourlyEventsDTO {
  private Events oneToSix;
  private Events sevenToTwelve;
  private Events thirteenToEighteen;
  private Events nineteenToTwentyFour;
}
