package com.jhanp.gestioneventos.repository.entity;

import com.jhanp.gestioneventos.domain.entity.InvitationOrganizationEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitationOrganizationEventRepository extends JpaRepository <InvitationOrganizationEvent, Integer> {
}

