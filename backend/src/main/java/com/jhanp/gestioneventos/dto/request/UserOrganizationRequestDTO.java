package com.jhanp.gestioneventos.dto.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserOrganizationRequestDTO {
    private Long idUser;
    private Long idOrganization;
    private String OrganizationRole;
}
