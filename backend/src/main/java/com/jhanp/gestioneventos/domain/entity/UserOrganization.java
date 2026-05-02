package com.jhanp.gestioneventos.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "usuario_organizacion")
public class UserOrganization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "organizacion_id")
    private Organization organization;

    @Column(name = "rol_en_org")
    private String roleInOrganization;

    @Column(name = "activo")
    private Boolean active;
}
