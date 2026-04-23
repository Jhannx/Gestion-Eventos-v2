package com.jhanp.gestioneventos.dto.response;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserOrganizationResponseDTO {
    private Long idUserOrganization;
    private UserResponseDTO userResponseDTO;
    private OrganizationResponseDTO organizationResponseDTO;
    private String OrganizationRole;
    private Boolean active;

}
