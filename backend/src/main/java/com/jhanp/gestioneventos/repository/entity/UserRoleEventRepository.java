package com.jhanp.gestioneventos.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleEventRepository extends JpaRepository<UserRoleEventRepository, Long> {
}
