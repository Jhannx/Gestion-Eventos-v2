package com.jhanp.gestioneventos.dto.request;

import java.time.Instant;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvitationUserEventoRequestDTO {
    private Integer idEvent;
    private Integer idUser;
    private String invitationStatus;
    private Instant sentDate;
    private Boolean active;
}

