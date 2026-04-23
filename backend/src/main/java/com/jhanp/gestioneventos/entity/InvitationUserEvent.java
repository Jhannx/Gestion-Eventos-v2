package com.jhanp.gestioneventos.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "invitacion_usuario_evento")
public class InvitationUserEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User user;

    @Column(name = "estado_invitacion")
    private String invitationStatus;

    @Column(name = "fecha_envio")
    private Instant sentDate;

    @Column(name = "activo")
    private Boolean active;
}
