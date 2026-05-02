package com.jhanp.gestioneventos.repository.view;

import com.jhanp.gestioneventos.domain.view.DetailEventView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailEventViewRepository extends JpaRepository<DetailEventView, Integer> {

    List<DetailEventView> findByIdEvent(Integer idEvent);

    List<DetailEventView> findByAccessType(String accessType);
}

