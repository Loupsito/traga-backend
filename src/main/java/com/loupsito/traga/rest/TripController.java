package com.loupsito.traga.rest;

import com.loupsito.traga.domain.dto.CreateTripDto;
import com.loupsito.traga.domain.dto.UpdateTripDto;
import com.loupsito.traga.infrastructure.database.TripEntity;
import com.loupsito.traga.infrastructure.database.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        return tripRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Trip not found"));
    }

    @PostMapping("/trips")
    public void createTrip(@RequestBody CreateTripDto createTripDto) {
        TripEntity entity = new TripEntity(createTripDto.name(), createTripDto.creator(), LocalDateTime.now());
        tripRepository.save(entity);
    }

    @PutMapping("/trips")
    public void updateTrip(@RequestBody UpdateTripDto updateTripDto) {
        TripEntity tripEntity = getTrip(updateTripDto.idTrip());
        tripEntity.setName(updateTripDto.name() != null ? updateTripDto.name() : tripEntity.getName());
        tripEntity.setCreator(updateTripDto.creator() != null ? updateTripDto.creator() : tripEntity.getCreator());
        tripRepository.save(tripEntity);
    }
}