package com.jhanp.gestioneventos.repository.entity;

import aj.org.objectweb.asm.commons.Remapper;
import com.jhanp.gestioneventos.domain.entity.Organization;
import com.jhanp.gestioneventos.domain.view.EventsByOrganizationView;
import com.jhanp.gestioneventos.domain.view.UsersByOrganizationView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

    Page<Organization> findByActiveTrue(Pageable pageable);
    Page<Organization> findByActiveFalse(Pageable pageable);

    List<Organization> findByNameContainingIgnoreCase(String q);
    boolean existsByName(String name);

    // Procedimiento
    @Procedure(procedureName = "sp_desactivar_organizacion")
    void deactivateOrganization(@Param("p_organizacion_id") Integer organizationId);
}
