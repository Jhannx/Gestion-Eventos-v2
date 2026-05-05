package com.jhanp.gestioneventos.repository.view;

import com.jhanp.gestioneventos.domain.view.UserRegistrationsView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationsViewRepository extends JpaRepository<UserRegistrationsView, Integer> {

    Page<UserRegistrationsView> findByUserIdentification(String userIdentification, Pageable pageable);

    Page<UserRegistrationsView> findByIdEvent(Integer idEvent, Pageable pageable);
}

