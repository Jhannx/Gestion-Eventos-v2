package com.jhanp.gestioneventos.repository.view;

import com.jhanp.gestioneventos.domain.view.CancelledEventsView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancelledEventsViewRepository extends JpaRepository<CancelledEventsView, Integer> {

    Page<CancelledEventsView> findByOrganization(String organization, Pageable pageable);

    Page<CancelledEventsView> findByNameContainingIgnoreCase(String name, Pageable pageable);
}

