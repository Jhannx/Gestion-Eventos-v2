package com.jhanp.gestioneventos.repository;

import com.jhanp.gestioneventos.entity.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTypeRepository extends JpaRepository <EventType, Long> {
}
