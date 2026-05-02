package com.jhanp.gestioneventos.repository.view;

import com.jhanp.gestioneventos.domain.view.CancelledEventsView;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancelledEventsViewRepository extends JpaRepository<CancelledEventsView, Integer> {

    Page<CancelledEventsView> findByOrganization(int page, int size, String organization);

    Page<CancelledEventsView> findByNameContainingIgnoreCase(int page, int size, String name);
}

