package com.jhanp.gestioneventos.dto.response;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventTypeResponseDTO {
    private Integer id;
    private String name;
    private String description;
    private Boolean active;
}

