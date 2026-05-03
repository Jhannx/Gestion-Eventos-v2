package com.jhanp.gestioneventos.repository.view;

import com.jhanp.gestioneventos.domain.view.ActiveUsersView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActiveUsersViewRepository extends JpaRepository<ActiveUsersView, Integer> {

    Page<ActiveUsersView> findByFirstNameContainingIgnoreCase(String name, Pageable pageable);

    Page<ActiveUsersView> findByLastNameContainingIgnoreCase(String lastName, Pageable pageable);

    Optional<ActiveUsersView> findByEmail(String email);
}

