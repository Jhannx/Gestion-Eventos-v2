package com.jhanp.gestioneventos.repository.entity;

import com.jhanp.gestioneventos.domain.entity.Registration;
import com.jhanp.gestioneventos.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository <Registration, Integer> {

    Page<Registration> findByActiveTrue(Pageable pageable);
    Page<Registration> findByActiveFalse(Pageable pageable);
    Page<Registration> findRegistrationByActiveFalse(Pageable pageable);

    // Procedimientos
    @Procedure(procedureName = "sp_inscribir_usuario")
    Integer registerUserToEvent(@Param("p_usuario_id") Integer idUser, @Param("p_acceso_evento_id") Integer idEventAccess);

    @Procedure(procedureName = "sp_cancelar_inscripcion")
    void cancelEventRegistration(@Param("p_inscripcion_id") Integer idRegistration);

    // Funciones
    @Query(value = "SELECT fn_total_inscritos(:eventId)", nativeQuery = true)
    Integer getTotalRegistrations(@Param("eventId") Integer idEvent);
}

