package com.jhanp.gestioneventos.repository.view;

import com.jhanp.gestioneventos.domain.view.PendingOrganizationInvitationsView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PendingOrganizationInvitationsViewRepository extends JpaRepository<PendingOrganizationInvitationsView, Integer> {

    Page<PendingOrganizationInvitationsView> findByIdOrganization(Integer idOrganization, Pageable pageable);

    Page<PendingOrganizationInvitationsView> findByIdEvent(Integer idEvent, Pageable pageable);
}

