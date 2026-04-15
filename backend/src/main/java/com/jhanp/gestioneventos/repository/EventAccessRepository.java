package com.jhanp.gestioneventos.repository;

import com.jhanp.gestioneventos.entity.EventAccess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventAccessRepository extends JpaRepository <EventAccess, Long> {
}
