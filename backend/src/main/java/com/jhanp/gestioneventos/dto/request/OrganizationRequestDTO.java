package com.jhanp.gestioneventos.dto.request;

import com.jhanp.gestioneventos.dto.response.UserOrganizationResponseDTO;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationRequestDTO {
    private Long id;
    private String name;
    private Boolean active;

    private Integer idOrganizationType;
    private List <UserOrganizationResponseDTO> members;
}

