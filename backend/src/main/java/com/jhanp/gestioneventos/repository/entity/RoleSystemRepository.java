package com.jhanp.gestioneventos.repository.entity;

import com.jhanp.gestioneventos.domain.entity.SystemRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleSystemRepository extends JpaRepository <SystemRole, Long> {
}
