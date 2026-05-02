package com.jhanp.gestioneventos.repository.view;

import com.jhanp.gestioneventos.domain.view.UserRegistrationsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRegistrationsViewRepository extends JpaRepository<UserRegistrationsView, Long> {

    List<UserRegistrationsView> findByIdUser(Long idUser);

    List<UserRegistrationsView> findByIdEvent(Long idEvent);
}
