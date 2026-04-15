package com.jhanp.gestioneventos.repository;

import com.jhanp.gestioneventos.entity.AccessType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessTypeRepository extends JpaRepository <AccessType, Long> {
}
