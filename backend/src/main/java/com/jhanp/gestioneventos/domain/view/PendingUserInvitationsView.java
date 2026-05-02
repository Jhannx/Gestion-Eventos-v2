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
@Table(name = "v_invitaciones_usuario_pendientes")
@Immutable
@Getter
@NoArgsConstructor
public class PendingUserInvitationsView {
    @Id
    private Long id;

    @Column(name = "evento_id")
    private Long idEvent;

    @Column(name = "evento")
    private String eventName;

    @Column(name = "fecha")
    private LocalDate date;

    @Column(name = "usuario_id")
    private Long idUser;

    @Column(name = "usuario_nombre")
    private String userName;

    @Column(name = "usuario_apellido")
    private String userLastName;

    private String email;

    @Column(name = "estado_invitacion")
    private String invitationStatus;

    @Column(name = "fecha_envio")
    private Instant sentDate;

}
