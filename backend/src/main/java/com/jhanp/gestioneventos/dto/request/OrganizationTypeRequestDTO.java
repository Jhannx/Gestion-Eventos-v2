package com.jhanp.gestioneventos.dto.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationTypeRequestDTO {
    private Integer id;
    private String name;
    private String description;
    private Boolean active;
}
