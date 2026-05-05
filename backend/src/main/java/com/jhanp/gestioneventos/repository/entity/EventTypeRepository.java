package com.jhanp.gestioneventos.repository.entity;

import com.jhanp.gestioneventos.domain.entity.EventType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventTypeRepository extends JpaRepository <EventType, Integer> {

    List<EventType> findByActiveTrue();

    List<EventType> findByActiveFalse();

    @Query("SELECT e FROM EventType e WHERE " +
            "CAST(e.id AS string) LIKE %:q% OR " +
            "LOWER(e.name) LIKE LOWER(CONCAT('%', :q, '%'))")

    List<EventType> searchByIdOrName(@Param("q") String q);
}

