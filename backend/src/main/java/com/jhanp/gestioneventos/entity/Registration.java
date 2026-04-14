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
@Table(name = "inscripcion")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "acceso_evento_id")
    private EventAccess eventAccess;

    @Column(name = "fecha_inscripcion")
    private LocalDateTime registrationDate;

    @Column(name = "estado_inscripcion")
    private String registrationStatus;

    @Column(name = "asistencia")
    private String attendance;

    @Column(name = "activo")
    private Boolean active;
}
