package com.jhanp.gestioneventos.repository.view;

import com.jhanp.gestioneventos.domain.view.UserRegistrationsView;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRegistrationsViewRepository extends JpaRepository<UserRegistrationsView, Integer> {

    Page<UserRegistrationsView> findByIdUser(int page, int size, Integer idUser);

    Page<UserRegistrationsView> findByIdEvent(int page, int size, Integer idEvent);
}

