package com.loupsito.traga.domain.rest;

import com.loupsito.traga.domain.dto.AddStepDto;
import com.loupsito.traga.domain.dto.CreateTripDto;
import com.loupsito.traga.infrastructure.database.TripEntity;
import com.loupsito.traga.infrastructure.database.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TripController {

    @Autowired
    TripRepository tripRepository;

    @GetMapping("/trips")
    public List<TripEntity> getAllTripsFromUser(@RequestParam(required = false) String userId) {
        return tripRepository.findAll();
    }

    @GetMapping("/trips/{id}")
    public TripEntity getTrip(@PathVariable("id") long id) {
        return tripRepository.findById(id).orElseThrow();
    }

    @PostMapping("/trips")
    public void createTrip(@RequestBody CreateTripDto createTripDto) {
        TripEntity entity = new TripEntity(createTripDto.name(), createTripDto.creator(), LocalDateTime.now());
        tripRepository.save(entity);
    }

    @PostMapping("/trips/step")
    public void addStep(@RequestBody AddStepDto addStepDto) {

    }
}