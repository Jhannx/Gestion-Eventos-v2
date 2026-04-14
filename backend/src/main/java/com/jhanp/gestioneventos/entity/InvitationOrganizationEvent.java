package com.jhanp.gestioneventos.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "invitacion_organizacion_evento")
public class InvitationOrganizationEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "organizacion_id")
    private Organization organization;

    @Column(name = "estado_invitacion")
    private String invitationStatus;

    @Column(name = "fecha_envio")
    private LocalDateTime sentDate;

    @Column(name = "activo")
    private Boolean active;
}
