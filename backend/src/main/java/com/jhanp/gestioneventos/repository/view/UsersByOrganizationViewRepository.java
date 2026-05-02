package com.jhanp.gestioneventos.repository.view;

import com.jhanp.gestioneventos.domain.view.UsersByOrganizationView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersByOrganizationViewRepository extends JpaRepository<UsersByOrganizationView, Long> {

    List<UsersByOrganizationView> findByIdOrganization(Long idOrganization);

    List<UsersByOrganizationView> findByIdUser(Long idUser);
}
