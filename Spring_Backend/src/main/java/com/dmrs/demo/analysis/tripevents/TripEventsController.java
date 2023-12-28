package com.dmrs.demo.analysis.tripevents;

import com.dmrs.demo.dto.TripEventsDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/analysis/tripEvents")
@AllArgsConstructor
public class TripEventsController {

    private final TripEventsService tripEventsService;

    @GetMapping
    public TripEventsDTO getTripEvents(@RequestParam String tripId){
        return tripEventsService.getTripEventsDTO(tripId);
    }

    @PostMapping
    public void save(@RequestParam String tripId , @RequestBody TripEventsDTO tripEventsRequest){
        tripEventsService.saveTripEvents(tripId,tripEventsRequest);
    }
}
