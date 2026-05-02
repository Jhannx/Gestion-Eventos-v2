package com.jhanp.gestioneventos.repository.view;

import com.jhanp.gestioneventos.domain.view.ActiveEventsView;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActiveEventsRepository extends JpaRepository <ActiveEventsView, Integer> {

    Page<ActiveEventsView> findByNameContainingIgnoreCase(int page, int size, String name);

    Page<ActiveEventsView> findByEventType(int page, int size, String eventType);

    Page<ActiveEventsView> findByOrganization(int page, int size, String organization);
}

