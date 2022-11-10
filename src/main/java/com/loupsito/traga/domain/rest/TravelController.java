package com.loupsito.traga.domain.rest;

import com.loupsito.traga.domain.dto.AddStepDto;
import com.loupsito.traga.domain.dto.CreateTravelDto;
import com.loupsito.traga.domain.model.Travel;
import com.loupsito.traga.infrastructure.database.TravelEntity;
import com.loupsito.traga.infrastructure.database.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TravelController {

    @Autowired
    TravelRepository travelRepository;

    @GetMapping("/travel")
    public List<Travel> getAllTravelsFromUser(@RequestParam(required = false) String userId) {
        return travelRepository
                .findAll()
                .stream()
                .map(travelEntity -> new Travel(travelEntity.getName(), travelEntity.getCreator(), travelEntity.getCreationDate()))
                .toList();
    }

    @PostMapping("/travel")
    public void createTravel(@RequestBody CreateTravelDto createTravelDto) {
        TravelEntity entity = new TravelEntity(createTravelDto.name(), createTravelDto.creator(), LocalDateTime.now());
        travelRepository.save(entity);
    }

    @PostMapping("/travel/step")
    public void addStep(@RequestBody AddStepDto addStepDto) {

    }
}