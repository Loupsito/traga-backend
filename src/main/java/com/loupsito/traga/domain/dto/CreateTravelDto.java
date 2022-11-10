package com.loupsito.traga.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public record CreateTravelDto(@NotNull @JsonProperty() String name, @NotNull @JsonProperty() String creator) {
    public CreateTravelDto(String name, String creator) {
        this.name = name;
        this.creator = creator;
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
