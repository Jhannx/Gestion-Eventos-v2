package com.jhanp.gestioneventos.repository;

import com.jhanp.gestioneventos.entity.SystemRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleSystemRepository extends JpaRepository <SystemRole, Long> {
}
