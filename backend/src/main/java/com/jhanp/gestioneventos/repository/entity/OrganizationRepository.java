package com.jhanp.gestioneventos.repository.entity;

import com.jhanp.gestioneventos.domain.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

    // Procedimiento
    @Procedure(procedureName = "sp_desactivar_organizacion")
    void deactivateOrganization(@Param("p_organizacion_id") Integer organizationId);
}

