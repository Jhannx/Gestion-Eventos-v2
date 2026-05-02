package com.jhanp.gestioneventos.repository.view;

import com.jhanp.gestioneventos.domain.view.OccupationEventView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OccupationEventViewRepository extends JpaRepository<OccupationEventView, Integer> {

    Optional<OccupationEventView> findByIdEvent(Integer idEvent);
}

