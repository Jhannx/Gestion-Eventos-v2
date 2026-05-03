package com.jhanp.gestioneventos.dto.request;

import java.math.BigDecimal;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventAccessRequestDTO {
    private Integer id;
    private BigDecimal price;
    private Integer spots;
    private String accessStatus;
    private Boolean active;

    private Integer idEvent;
    private Integer idAccessType;
}

