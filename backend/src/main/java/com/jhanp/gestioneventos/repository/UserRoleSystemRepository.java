package com.jhanp.gestioneventos.repository;

import com.jhanp.gestioneventos.entity.UserSystemRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleSystemRepository extends JpaRepository<UserSystemRole, Long> {
}
