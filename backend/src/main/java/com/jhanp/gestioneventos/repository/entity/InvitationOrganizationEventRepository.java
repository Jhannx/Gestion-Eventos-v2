package com.jhanp.gestioneventos.repository.entity;

import com.jhanp.gestioneventos.domain.entity.InvitationOrganizationEvent;
import com.jhanp.gestioneventos.domain.entity.InvitationUserEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitationOrganizationEventRepository extends JpaRepository <InvitationOrganizationEvent, Integer> {
    Page<InvitationOrganizationEvent> findByActiveTrue(Pageable pageable);
    Page<InvitationOrganizationEvent> findByActiveFalse(Pageable pageable);
}

