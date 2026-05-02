package com.jhanp.gestioneventos.dto.request;

import java.math.BigDecimal;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventAccessRequestDTO {
    private BigDecimal price;
    private Integer spots;

    private Long idEvent;
    private Long idAccessType;
}
