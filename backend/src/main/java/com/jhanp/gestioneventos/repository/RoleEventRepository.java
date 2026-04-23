package com.jhanp.gestioneventos.repository;

import com.jhanp.gestioneventos.entity.EventRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleEventRepository extends JpaRepository<EventRole, Long> {
}
