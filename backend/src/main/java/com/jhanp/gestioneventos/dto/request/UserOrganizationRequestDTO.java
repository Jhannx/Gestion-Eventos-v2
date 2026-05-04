package com.jhanp.gestioneventos.dto.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserOrganizationRequestDTO {
    private Integer id;
    private Integer idUser;
    private Integer idOrganization;
    private String OrganizationRole;
    private Boolean active;
}

