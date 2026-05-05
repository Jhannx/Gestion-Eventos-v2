package com.jhanp.gestioneventos.repository.entity;

import com.jhanp.gestioneventos.domain.entity.EventRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRoleRepository extends JpaRepository<EventRole, Integer> {
    List<EventRole> findByActiveTrue();
    List<EventRole> findByActiveFalse();
}

