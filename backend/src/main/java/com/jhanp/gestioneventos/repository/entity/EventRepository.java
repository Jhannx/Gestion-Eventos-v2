package com.jhanp.gestioneventos.repository.entity;

import com.jhanp.gestioneventos.domain.entity.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository <Event, Integer> {

    Page<Event> findByActiveFalse(Pageable pageable);

    List<Event> findByNameContainingIgnoreCase(String name);

    // Funciones
    @Query(value = "SELECT fn_porcentaje_ocupacion(:eventId)", nativeQuery = true)
    Double getOccupationPercentage(@Param("eventId") Integer idEvent);
}

