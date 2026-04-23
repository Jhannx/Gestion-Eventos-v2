package com.jhanp.gestioneventos.dto.response;

import java.math.BigDecimal;
import java.util.List;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventAccessResponseDTO {
    private Long id;
    private BigDecimal price;
    private Integer slots;
    private String accessStatus;
    private Boolean active;

    private EventResponseDTO event;
    private AccessTypeResponseDTO access;
    private List<RegistrationResponseDTO> registrations;
}
