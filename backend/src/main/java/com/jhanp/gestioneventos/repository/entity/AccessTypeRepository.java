package com.jhanp.gestioneventos.repository.entity;

import com.jhanp.gestioneventos.domain.entity.AccessType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessTypeRepository extends JpaRepository <AccessType, Long> {
}
