package com.jhanp.gestioneventos.repository.view;

import com.jhanp.gestioneventos.domain.view.AvailableAccessView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailableAccessViewRepository extends JpaRepository<AvailableAccessView, Integer> {

    List<AvailableAccessView> findByIdEvent(Integer idEvent);

    List<AvailableAccessView> findByAccessType(String accessType);
}

