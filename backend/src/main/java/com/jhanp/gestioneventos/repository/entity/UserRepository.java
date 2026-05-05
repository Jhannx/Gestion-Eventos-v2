package com.jhanp.gestioneventos.repository.entity;

import com.jhanp.gestioneventos.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Page<User> findUserByActiveFalse(Pageable pageable);


    // Procedimientos
    @Procedure(procedureName = "sp_desactivar_usuario")
    void deactivateUser(@Param("p_usuario_id") Integer idUser, @Param("p_forzar") Boolean force);

    // Funciones
    @Query(value = "SELECT fn_usuario_tiene_rol(:userId, :roleName)", nativeQuery = true)
    Boolean userRole(@Param("userId") Integer idUser, @Param("roleName") String roleName);

    Optional<User> findByIdentificationNumber(String identificationNumber);
}

