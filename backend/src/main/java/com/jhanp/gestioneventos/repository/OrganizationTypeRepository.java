package com.jhanp.gestioneventos.repository;

import com.jhanp.gestioneventos.entity.OrganizationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationTypeRepository extends JpaRepository <OrganizationType, Long> {
}
