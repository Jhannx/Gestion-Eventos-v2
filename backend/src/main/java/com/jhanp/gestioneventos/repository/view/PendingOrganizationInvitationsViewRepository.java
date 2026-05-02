package com.jhanp.gestioneventos.repository.view;

import com.jhanp.gestioneventos.domain.view.PendingOrganizationInvitationsView;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PendingOrganizationInvitationsViewRepository extends JpaRepository<PendingOrganizationInvitationsView, Integer> {

    Page<PendingOrganizationInvitationsView> findByIdOrganization(int page, int size, Integer idOrganization);

    Page<PendingOrganizationInvitationsView> findByIdEvent(int page, int size, Integer idEvent);
}

