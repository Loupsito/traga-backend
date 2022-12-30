package com.loupsito.traga.rest;

import com.loupsito.traga.domain.dto.CreateTripDto;
import com.loupsito.traga.domain.dto.UpdateTripDto;
import com.loupsito.traga.infrastructure.database.TripEntity;
import com.loupsito.traga.infrastructure.database.TripRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TripController {

    private final String BEARER_NAME = "Bearer Authentication";
    @Autowired
    TripRepository tripRepository;

    @Operation(summary = "Get trips", description = "Get trips from a user")
    @SecurityRequirement(name = BEARER_NAME)
    @GetMapping("/trips")
    public List<TripEntity> getAllTripsFromUser(@RequestParam(required = false) String userId) {
        return tripRepository.findAll();
    }

    @Operation(summary = "Get one trip", description = "Get one trip by specifying its id")
    @SecurityRequirement(name = BEARER_NAME)
    @GetMapping("/trips/{tripId}")
    public TripEntity getTrip(@PathVariable("tripId") long tripId) {
        return tripRepository.findById(tripId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Trip not found"));
    }

    @Operation(summary = "Create a trip", description = "Create a trip")
    @SecurityRequirement(name = BEARER_NAME)
    @PostMapping("/trips")
    public void createTrip(@RequestBody CreateTripDto createTripDto) {
        TripEntity entity = new TripEntity(createTripDto.name(), createTripDto.creator(), LocalDateTime.now());
        tripRepository.save(entity);
    }

    @Operation(summary = "Update a trip", description = "Update a trip")
    @SecurityRequirement(name = BEARER_NAME)
    @PutMapping("/trips")
    public void updateTrip(@RequestBody UpdateTripDto updateTripDto) {
        TripEntity tripEntity = getTrip(updateTripDto.tripId());
        tripEntity.setName(updateTripDto.name() != null ? updateTripDto.name() : tripEntity.getName());
        tripEntity.setCreator(updateTripDto.creator() != null ? updateTripDto.creator() : tripEntity.getCreator());
        tripRepository.save(tripEntity);
    }

    @Operation(summary = "Delete a trip", description = "Delete a trip")
    @SecurityRequirement(name = BEARER_NAME)
    @DeleteMapping("/trips/{tripId}")
    public void deleteTrip(@PathVariable("tripId") long tripId) {
        TripEntity tripEntity = getTrip(tripId);
        tripRepository.delete(tripEntity);
    }
}