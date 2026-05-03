package com.jhanp.gestioneventos.domain.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "v_invitaciones_organizacion_pendientes")
@Immutable
@Getter
@NoArgsConstructor
public class PendingOrganizationInvitationsView {
    @Id
    private Integer id;

    @Column(name = "evento_id")
    private Integer idEvent;

    @Column(name = "evento")
    private String eventName;

    @Column(name = "fecha")
    private LocalDate date;

    @Column(name = "organizacion_id")
    private Integer idOrganization;

    @Column(name = "organizacion")
    private String organizationName;

    @Column(name = "estado_invitacion")
    private String invitationStatus;

    @Column(name = "fecha_envio")
    private Instant sentDate;
}

