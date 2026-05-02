package com.jhanp.gestioneventos.repository.entity;

import com.jhanp.gestioneventos.domain.entity.EventAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface EventAccessRepository extends JpaRepository <EventAccess, Integer> {

    // Procedimientos
    @Procedure(procedureName = "sp_crear_acceso_evento")
    void createEventAccess(@Param("p_evento_id") Integer idEvent, @Param("p_tipo_acceso_id") Integer idAccessType,
            @Param("p_precio") BigDecimal price, @Param("p_cupos") Integer spots);

    // Funciones
    @Query(value = "SELECT fn_cupos_disponibles(:eventId)", nativeQuery = true)
    Integer getAvailableSpots(@Param("eventId") Integer idEvent);
}

