package com.jhanp.gestioneventos.dto.request;

import java.time.Instant;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvitationUserEventoRequestDTO {
    private Long idEvent;
    private Long idUser;
    private String invitationStatus;
    private Instant sentDate;
    private Boolean active;
}
