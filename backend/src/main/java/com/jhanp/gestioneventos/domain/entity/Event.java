package com.jhanp.gestioneventos.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "evento")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tipo_evento_id")
    private EventType eventType;

    @ManyToOne
    @JoinColumn(name = "organizacion_id")
    private Organization organization;

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

    @Column(name = "activo")
    private Boolean active;

    @OneToMany(mappedBy = "event")
    private List<EventAccess> accesses;
}

