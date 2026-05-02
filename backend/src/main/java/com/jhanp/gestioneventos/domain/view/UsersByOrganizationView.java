package com.jhanp.gestioneventos.domain.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "v_usuarios_por_organizacion")
@Immutable
@Getter
@NoArgsConstructor
public class UsersByOrganizationView {
    @Id
    private Integer id;

    @Column(name = "organizacion_id")
    private Integer idOrganizacion;

    @Column(name = "organizacion")
    private String organizationName;

    @Column(name = "usuario_id")
    private Integer idUser;

    @Column(name = "usuario_nombre")
    private String userName;

    @Column(name = "usuario_apellido")
    private String userLastName;

    private String email;

    @Column(name = "telefono")
    private String phone;

    @Column(name = "rol_en_org")
    private String organizationRole;
}

