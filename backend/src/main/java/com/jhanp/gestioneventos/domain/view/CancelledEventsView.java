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
@Table(name = "v_eventos_cancelados")
@Immutable
@Getter
@NoArgsConstructor
public class CancelledEventsView {
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

    @Column(name = "estado_evento")
    private String eventStatus;

    @Column(name = "tipo_evento")
    private String eventType;

    @Column(name = "organizacion")
    private String organization;
}
