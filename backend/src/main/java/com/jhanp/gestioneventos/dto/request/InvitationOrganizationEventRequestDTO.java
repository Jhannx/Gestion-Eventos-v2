package com.jhanp.gestioneventos.dto.request;

import lombok.*;

import java.time.Instant;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvitationOrganizationEventRequestDTO {
    private Integer id;
    private Integer idEvent;
    private Integer idOrganization;
    private String invitationStatus;
    private Instant sentDate;
    private Boolean active;
}

