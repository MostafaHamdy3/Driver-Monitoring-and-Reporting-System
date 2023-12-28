package com.dmrs.demo.analysis.totalEvents;


import com.dmrs.demo.dto.TotalEventsDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/analysis/totalEvents")
@AllArgsConstructor
public class TotalEventsController {

  private final TotalEventsService totalEventsService;

  @GetMapping
  public TotalEventsDTO getTotalEvents(@RequestParam String driverId){
    return totalEventsService.getTotalEvents(driverId);
  }

  @PostMapping
  public void save(@RequestParam String driverId , @RequestBody TotalEventsDTO totalEventsRequest){
    totalEventsService.save(driverId,totalEventsRequest);
  }
}
