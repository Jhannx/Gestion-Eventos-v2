package com.jhanp.gestioneventos.repository.entity;

import com.jhanp.gestioneventos.domain.entity.UserOrganization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOrganizationRepository extends JpaRepository <UserOrganization, Long> {
}
