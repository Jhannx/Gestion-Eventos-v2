package com.jhanp.gestioneventos.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "organizacion")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tipo_organizacion_id")
    private OrganizationType organizationType;

    @Column(name = "nombre")
    private String name;

    @Column(name = "activo")
    private Boolean active;

    @OneToMany(mappedBy = "organization")
    private List<Event> events;

    @OneToMany(mappedBy = "organization")
    private List<UserOrganization> members;

    @OneToMany(mappedBy = "organization")
    private List<InvitationOrganizationEvent> invitations;
}
