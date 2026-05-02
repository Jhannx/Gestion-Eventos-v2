package com.jhanp.gestioneventos.domain.view;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;


@Entity
@Table(name = "v_usuarios_activos")
@Immutable
@Getter
@NoArgsConstructor
public class ActiveUsersView {
    @Id
    private Long id;

    @Column(name = "tipo_identificacion")
    private String identificationType;

    @Column(name = "numero_identificacion")
    private String identificationNumber;

    @Column(name = "nombre")
    private String firstName;

    @Column(name = "apellido_1")
    private String lastName;

    @Column(name = "apellido_2")
    private String secondLastName;

    @Column(name = "telefono")
    private String phone;

    private String email;

    @Column(name = "rol_sistema")
    private String systemRole;

}
