package com.jhanp.gestioneventos.repository.view;

import com.jhanp.gestioneventos.domain.view.EventsByOrganizationView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsByOrganizationViewRepository extends JpaRepository<EventsByOrganizationView, Long> {

    List<EventsByOrganizationView> findByIdOrganization(Long idOrganization);
}
