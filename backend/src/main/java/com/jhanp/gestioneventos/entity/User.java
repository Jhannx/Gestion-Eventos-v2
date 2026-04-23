package com.jhanp.gestioneventos.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "usuario")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_identificacion")
    private String identificationType;

    @Column(name = "numero_identificacion")
    private String identificationNumber;

    @Column(name = "nombre")
    private String firstName;

    @Column(name = "apellido_1")
    private String lastName;

    @Column(name = "apellido_2")
    private String secondLastName;

    @Column(name = "telefono")
    private String phone;

    private String email;

    private String password;

    @Column(name = "activo")
    private Boolean active;

    @OneToMany(mappedBy = "user")
    private List<UserSystemRole> userSystemRoles;

    @OneToMany(mappedBy = "user")
    private List<Registration> registrations;

    @OneToMany(mappedBy = "user")
    private List<UserOrganization> organizations;

    @OneToMany(mappedBy = "user")
    private List<InvitationUserEvent> invitations;
}
