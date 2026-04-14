package com.jhanp.gestioneventos.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "acceso_evento")
public class EventAccess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "tipo_acceso_id")
    private AccessType accessType;

    @Column(name = "precio")
    private BigDecimal price;

    @Column(name = "cupos")
    private Integer slots;

    @Column(name = "estado_acceso")
    private String accessStatus;

    @Column(name = "activo")
    private Boolean active;

    @OneToMany(mappedBy = "eventAccess")
    private List<Registration> registrations;
}
