package com.jhanp.gestioneventos.repository.view;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OccupationEventViewRepository extends JpaRepository<OccupationEventViewRepository, Long> {

    Optional<OccupationEventViewRepository> findByIdEvent(Long idEvent);
}
