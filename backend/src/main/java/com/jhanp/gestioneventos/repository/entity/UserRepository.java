package com.jhanp.gestioneventos.repository.entity;

import com.jhanp.gestioneventos.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Procedimientos
    @Procedure(procedureName = "sp_desactivar_usuario")
    void inactivateUser(@Param("p_usuario_id") Integer idUser, @Param("p_forzar") Boolean force);

    // Funciones
    @Query(value = "SELECT fn_usuario_tiene_rol(:userId, :roleName)", nativeQuery = true)
    Boolean userRole(@Param("userId") Integer idUser, @Param("roleName") String roleName);
}
