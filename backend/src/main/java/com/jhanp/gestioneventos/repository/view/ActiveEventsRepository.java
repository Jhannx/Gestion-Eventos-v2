package com.jhanp.gestioneventos.repository.view;

import com.jhanp.gestioneventos.domain.view.ActiveEventsView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActiveEventsRepository extends JpaRepository <ActiveEventsView, Integer> {

    Page<ActiveEventsView> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Page<ActiveEventsView> findByEventType(String eventType, Pageable pageable);

    Page<ActiveEventsView> findByOrganization(String organization, Pageable pageable);
}

