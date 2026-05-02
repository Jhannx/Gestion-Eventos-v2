package com.jhanp.gestioneventos.repository.view;

import com.jhanp.gestioneventos.domain.view.EventsByOrganizationView;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsByOrganizationViewRepository extends JpaRepository<EventsByOrganizationView, Integer> {

    Page<EventsByOrganizationView> findByIdOrganization(int page, int size, Integer idOrganization);
}

