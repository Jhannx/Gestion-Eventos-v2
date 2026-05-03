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
@Table(name = "v_accesos_disponibles")
@Immutable
@Getter
@NoArgsConstructor
public class AvailableAccessView {
    @Id
    @Column(name = "acceso_id")
    private Integer idEventAccess;

    @Column(name = "evento_id")
    private Integer idEvent;

    @Column(name = "evento")
    private String eventName;

    @Column(name = "fecha")
    private LocalDate date;

    @Column(name = "estado_evento")
    private String eventStatus;

    @Column(name = "tipo_acceso")
    private String accessType;

    @Column(name = "precio")
    private BigDecimal price;

    @Column(name = "cupos_disponibles")
    private Integer available_spots;

    @Column(name = "estado_acceso")
    private String accessStatus;
}

