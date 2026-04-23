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
    private Integer slots;

    private Long idEvent;
    private Long idAccessType;
}
