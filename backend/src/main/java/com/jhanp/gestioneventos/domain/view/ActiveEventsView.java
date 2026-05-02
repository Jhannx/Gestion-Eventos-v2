package com.jhanp.gestioneventos.domain.view;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "v_eventos_activos")
@Immutable
@Getter
@NoArgsConstructor
public class ActiveEventsView {

    @Id
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "direccion")
    private String address;

    @Column(name = "lugar")
    private String place;

    @Column(name = "fecha")
    private LocalDate date;

    @Column(name = "hora_inicio")
    private LocalTime startTime;

    @Column(name = "hora_fin")
    private LocalTime endTime;

    @Column(name = "capacidad")
    private Integer capacity;

    @Column(name = "restriccion_acceso")
    private String accessRestriction;

    @Column(name = "estado_evento")
    private String eventStatus;

    @Column(name = "tipo_evento")
    private String eventType;

    @Column(name = "organizacion")
    private String organization;

}
