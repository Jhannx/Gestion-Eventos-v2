package com.jhanp.gestioneventos.dto.response;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationResponseDTO {
    private Long id;
    private String name;
    private OrganizationTypeResponseDTO organizationType;
    private Boolean active;

    private List<EventResponseDTO> events;
    private List<UserOrganizationResponseDTO> members;
    private List<InvitationOrganizationEventResponseDTO> invitations;


}
