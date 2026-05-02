package com.jhanp.gestioneventos.repository.entity;

import com.jhanp.gestioneventos.domain.entity.EventRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleEventRepository extends JpaRepository<EventRole, Integer> {
}

