package com.loupsito.traga.domain.model;

import java.time.LocalDateTime;

public class Travel {
    private final String name;
    private final String creator;
    private final LocalDateTime creationDate;

    public Travel(String name, String creator, LocalDateTime creationDate) {
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
