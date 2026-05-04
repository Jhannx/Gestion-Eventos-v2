package com.jhanp.gestioneventos.dto.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SystemRoleRequestDTO {
    private Integer id;
    private String name;
    private String description;
    private Boolean active;
}
