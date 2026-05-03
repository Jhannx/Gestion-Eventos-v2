package com.jhanp.gestioneventos.repository.view;

import com.jhanp.gestioneventos.domain.view.PendingUserInvitationsView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PendingUserInvitationsViewRepository extends JpaRepository<PendingUserInvitationsView, Integer> {

    Page<PendingUserInvitationsView> findByIdUser(Integer idUser, Pageable pageable);

    Page<PendingUserInvitationsView> findByIdEvent(Integer idEvent, Pageable pageable);
}

