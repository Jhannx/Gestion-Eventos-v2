package com.jhanp.gestioneventos.repository.entity;

import com.jhanp.gestioneventos.domain.entity.AccessType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessTypeRepository extends JpaRepository <AccessType, Integer> {

    List<AccessType> findByActiveTrue();

    List<AccessType> findByActiveFalse();

    Boolean existsByName(String name);
}

