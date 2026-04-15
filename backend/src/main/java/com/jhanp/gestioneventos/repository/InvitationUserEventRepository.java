package com.jhanp.gestioneventos.repository;

import com.jhanp.gestioneventos.entity.InvitationUserEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvitationUserEventRepository extends JpaRepository <InvitationUserEvent, Long> {
}
