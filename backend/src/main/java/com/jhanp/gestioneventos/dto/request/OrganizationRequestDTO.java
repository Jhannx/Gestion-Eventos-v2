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
    private String name;

    private Long idEventType;
    private List <UserOrganizationResponseDTO> members;

}
