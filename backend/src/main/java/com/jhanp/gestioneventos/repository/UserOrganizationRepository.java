package com.jhanp.gestioneventos.repository;

import com.jhanp.gestioneventos.entity.UserOrganization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOrganizationRepository extends JpaRepository <UserOrganization, Long> {
}
