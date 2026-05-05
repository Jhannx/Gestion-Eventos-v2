package com.jhanp.gestioneventos.repository.entity;

import com.jhanp.gestioneventos.domain.entity.InvitationUserEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitationUserEventRepository extends JpaRepository <InvitationUserEvent, Integer> {
    Page<InvitationUserEvent> findByActiveTrue(Pageable pageable);
    Page<InvitationUserEvent> findByActiveFalse(Pageable pageable);
}

