package com.jhanp.gestioneventos.repository.entity;

import com.jhanp.gestioneventos.domain.entity.UserSystemRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSystemRoleRepository extends JpaRepository<UserSystemRole, Integer> {
}

