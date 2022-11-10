package com.loupsito.traga.infrastructure.database;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TravelRepository extends JpaRepository<TravelEntity, Integer> {
    List<TravelEntity> findAllByCreator(String userId);
}
