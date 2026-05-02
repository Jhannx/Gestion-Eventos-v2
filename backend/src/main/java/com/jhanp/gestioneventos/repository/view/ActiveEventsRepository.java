package com.jhanp.gestioneventos.repository.view;

import com.jhanp.gestioneventos.domain.view.ActiveEventsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActiveEventsRepository extends JpaRepository <ActiveEventsView, Long> {

    List<ActiveEventsView> findByNameContainingIgnoreCase(String name);

    List<ActiveEventsView> findByEventType(String eventType);

    List<ActiveEventsView> findByOrganization(String organization);
}
