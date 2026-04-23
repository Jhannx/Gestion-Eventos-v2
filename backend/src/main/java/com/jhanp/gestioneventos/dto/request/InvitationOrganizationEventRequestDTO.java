package com.jhanp.gestioneventos.dto.request;

import lombok.*;

import java.time.Instant;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvitationOrganizationEventRequestDTO {
    private Long idEvent;
    private Long idOrganization;
    private String invitationStatus;
    private Instant sentDate;
    private Boolean active;
}
