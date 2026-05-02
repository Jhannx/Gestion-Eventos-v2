package com.jhanp.gestioneventos.repository.view;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CancelledEventsViewRepository extends JpaRepository<CancelledEventsViewRepository, Long> {

    List<CancelledEventsViewRepository> findByOrganization(String organization);

    List<CancelledEventsViewRepository> findByNameContainingIgnoreCase(String name);
}
