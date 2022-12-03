package com.loupsito.traga.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateTripDto(@JsonProperty() long idTrip, @JsonProperty() String name, @JsonProperty() String creator) {
    public UpdateTripDto(long idTrip, String name, String creator) {
        this.idTrip = idTrip;
        this.name = name;
        this.creator = creator;
    }

    @Override
    public long idTrip() {
        return idTrip;
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
