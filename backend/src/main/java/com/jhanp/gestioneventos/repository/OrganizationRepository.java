package com.jhanp.gestioneventos.repository;

import com.jhanp.gestioneventos.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
