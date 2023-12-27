package com.dmrs.demo.analysis.totalHourlyEvents;

import com.dmrs.demo.dto.TotalHourlyEventsDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/analysis/totalHourlyEvents")
@AllArgsConstructor
public class TotalHourlyEventsController {

    private final TotalHourlyEventsService totalHourlyEventsService;

    @GetMapping
    public TotalHourlyEventsDTO getTotalHourlyEvents(@RequestParam String driverId){
      return totalHourlyEventsService.getByDriverId(driverId);
    }

    @PostMapping
    public void save(@RequestParam String driverId , @RequestBody TotalHourlyEventsDTO totalHourlyEventsRequest){
      totalHourlyEventsService.save(driverId,totalHourlyEventsRequest);
    }
}
