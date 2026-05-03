package com.jhanp.gestioneventos.dto.request;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccessTypeRequestDTO {
    private Integer id;
    private String name;
    private String description;
    private Boolean active;
    private List<EventAccessRequestDTO> eventAccesses;
}
