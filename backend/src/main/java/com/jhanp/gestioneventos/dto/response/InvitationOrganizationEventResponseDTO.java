package com.jhanp.gestioneventos.dto.response;

import lombok.*;

import java.time.Instant;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvitationOrganizationEventResponseDTO {
    private Long id;
    private EventResponseDTO event;
    private OrganizationResponseDTO organization;
    private String invitationStatus;
    private Instant sentDate;
    private Boolean active;
}
