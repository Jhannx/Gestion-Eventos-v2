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
@Table(name = "rol_evento")
public class EventRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "activo")
    private Boolean active;

    @OneToMany(mappedBy = "roleEvent")
    private List<UserEventRole> userRoles;
}
