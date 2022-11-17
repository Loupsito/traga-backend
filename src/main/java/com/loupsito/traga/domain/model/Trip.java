package com.loupsito.traga.domain.model;

import java.time.LocalDateTime;

public class Trip {
    private final String name;
    private final String creator;
    private final LocalDateTime creationDate;

    public Trip(String name, String creator, LocalDateTime creationDate) {
        this.name = name;
        this.creator = creator;
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getCreator() {
        return creator;
    }
}
