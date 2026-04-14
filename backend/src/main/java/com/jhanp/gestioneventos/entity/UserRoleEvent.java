package com.jhanp.gestioneventos.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "usuario_rol_evento")
public class UserRoleEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "rol_evento_id")
    private RoleEvent roleEvent;

    @Column(name = "activo")
    private Boolean active;
}
