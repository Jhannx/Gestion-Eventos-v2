package com.jhanp.gestioneventos.repository.view;

import com.jhanp.gestioneventos.domain.view.UsersByOrganizationView;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersByOrganizationViewRepository extends JpaRepository<UsersByOrganizationView, Integer> {

    Page<UsersByOrganizationView> findByIdOrganization(int page, int size, Integer idOrganization);

    Page<UsersByOrganizationView> findByIdUser(int page, int size, Integer idUser);
}

