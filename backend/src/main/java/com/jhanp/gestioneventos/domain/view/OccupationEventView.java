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
@Table(name = "v_ocupacion_evento")
@Immutable
@Getter
@NoArgsConstructor
public class OccupationEventView {
    @Id
    @Column(name = "evento_id")
    private Integer idEvent;

    @Column(name = "evento")
    private String name;

    @Column(name = "fecha")
    private LocalDate date;

    @Column(name = "capacidad")
    private Integer capacity;

    @Column(name = "total_inscritos")
    private Integer totalRegistered;

    @Column(name = "cupos_disponibles")
    private Integer available_spots;

    @Column(name = "porcentaje_ocupacion")
    private BigDecimal occupancyPercentage;
}

