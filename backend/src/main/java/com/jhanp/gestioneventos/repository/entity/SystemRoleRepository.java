package com.jhanp.gestioneventos.repository.entity;

import com.jhanp.gestioneventos.domain.entity.SystemRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemRoleRepository extends JpaRepository <SystemRole, Integer> {
    List<SystemRole> findByActiveTrue();
    List<SystemRole> findByActiveFalse();
}

