package com.jhanp.gestioneventos.domain.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "v_inscripciones_usuario")
@Immutable
@Getter
@NoArgsConstructor
public class UserRegistrationsView {
    @Id
    @Column(name = "inscripcion_id")
    private Integer idRegistration;

    @Column(name = "usuario_id")
    private Integer idUser;

    @Column(name = "usuario_nombre")
    private String userName;

    @Column(name = "usuario_apellido")
    private String userLastName;

    private String email;

    @Column(name = "evento_id")
    private Integer idEvent;

    @Column(name = "evento")
    private String eventName;

    @Column(name = "lugar")
    private String place;

    @Column(name = "fecha")
    private LocalDate date;

    @Column(name = "tipo_acceso")
    private String accessType;

    @Column(name = "precio")
    private BigDecimal price;

    @Column(name = "fecha_inscripcion")
    private LocalDate registrationDate;

    @Column(name = "estado_inscripcion")
    private String registrationStatus;

    @Column(name = "asistencia")
    private String attendance;
}

