package com.jhanp.gestioneventos.repository.entity;

import com.jhanp.gestioneventos.domain.entity.OrganizationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationTypeRepository extends JpaRepository <OrganizationType, Long> {
}
