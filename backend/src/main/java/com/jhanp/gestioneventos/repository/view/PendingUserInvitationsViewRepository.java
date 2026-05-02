package com.jhanp.gestioneventos.repository.view;

import com.jhanp.gestioneventos.domain.view.PendingUserInvitationsView;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PendingUserInvitationsViewRepository extends JpaRepository<PendingUserInvitationsView, Integer> {

    Page<PendingUserInvitationsView> findByIdUser(int page, int size, Integer idUser);

    Page<PendingUserInvitationsView> findByIdEvent(int page, int size, Integer idEvent);
}

