package com.dmrs.demo.analysis.totalHourlyEvents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document
public class TotalHourlyEvents {
  @Id
  private String id;
  @Indexed(unique = true)
  private String driverId;
  private Events oneToSix;
  private Events sevenToTwelve;
  private Events thirteenToEighteen;
  private Events nineteenToTwentyFour;

  public TotalHourlyEvents(String DriverId, Events oneToSix, Events sevenToTwelve, Events thirteenToEighteen, Events nineteenToTwentyFour) {
    this.driverId = DriverId;
    this.oneToSix = oneToSix;
    this.sevenToTwelve = sevenToTwelve;
    this.thirteenToEighteen = thirteenToEighteen;
    this.nineteenToTwentyFour = nineteenToTwentyFour;
  }
}
