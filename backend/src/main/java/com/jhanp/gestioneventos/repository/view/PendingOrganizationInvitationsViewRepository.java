package com.jhanp.gestioneventos.repository.view;

import com.jhanp.gestioneventos.domain.view.PendingOrganizationInvitationsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PendingOrganizationInvitationsViewRepository extends JpaRepository<PendingOrganizationInvitationsView, Long> {

    List<PendingOrganizationInvitationsView> findByIdOrganization(Long idOrganization);

    List<PendingOrganizationInvitationsView> findByIdEvent(Long idEvent);
}
