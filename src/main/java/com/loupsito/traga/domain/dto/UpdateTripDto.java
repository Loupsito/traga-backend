package com.loupsito.traga.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateTripDto(@JsonProperty() long tripId, @JsonProperty() String name, @JsonProperty() String creator) {
    public UpdateTripDto(long tripId, String name, String creator) {
        this.tripId = tripId;
        this.name = name;
        this.creator = creator;
    }

    @Override
    public long tripId() {
        return tripId;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String creator() {
        return creator;
    }
}
