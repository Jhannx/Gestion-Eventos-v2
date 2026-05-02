package com.jhanp.gestioneventos.repository.view;

import com.jhanp.gestioneventos.domain.view.PendingUserInvitationsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PendingUserInvitationsViewRepository extends JpaRepository<PendingUserInvitationsView, Long> {

    List<PendingUserInvitationsView> findByIdUser(Long idUser);

    List<PendingUserInvitationsView> findByIdEvent(Long idEvent);
}
