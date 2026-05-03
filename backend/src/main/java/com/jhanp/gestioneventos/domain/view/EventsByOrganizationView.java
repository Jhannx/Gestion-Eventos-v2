package com.jhanp.gestioneventos.domain.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import java.time.LocalDate;

@Entity
@Table(name = "v_eventos_por_organizacion")
@Immutable
@Getter
@NoArgsConstructor
public class EventsByOrganizationView {
    @Id
    private Integer id;

    @Column(name = "organizacion_id")
    private Integer idOrganization;

    @Column(name = "organizacion")
    private String organizationName;

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
}

