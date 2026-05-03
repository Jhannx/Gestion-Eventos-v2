package com.jhanp.gestioneventos.repository.view;

import com.jhanp.gestioneventos.domain.view.UsersByOrganizationView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersByOrganizationViewRepository extends JpaRepository<UsersByOrganizationView, Integer> {

    Page<UsersByOrganizationView> findByIdOrganization(Integer idOrganization, Pageable pageable);

    Page<UsersByOrganizationView> findByIdUser(Integer idUser, Pageable pageable);
}

