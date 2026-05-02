package com.jhanp.gestioneventos.domain.view;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "v_evento_detalle")
@Immutable
@Getter
@NoArgsConstructor
public class DetailEventView {
    @Id
    private Integer id;

    @Column(name = "evento_id")
    private Integer idEvent;

    @Column(name = "evento")
    private String name;

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

    @Column(name = "tipo_acceso")
    private String accessType;

    @Column(name = "precio")
    private BigDecimal price;

    @Column(name = "cupos_disponibles")
    private Integer availableSpots;

    @Column(name = "estado_acceso")
    private String accessStatus;
}

