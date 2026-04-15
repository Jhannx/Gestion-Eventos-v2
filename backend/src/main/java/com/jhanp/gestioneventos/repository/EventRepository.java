package com.jhanp.gestioneventos.repository;

import com.jhanp.gestioneventos.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository <Event, Long> {
}
