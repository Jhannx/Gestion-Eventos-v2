package com.jhanp.gestioneventos.dto.response;

import lombok.*;

import java.time.Instant;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvitationUserEventResponseDTO {
    private Long id;
    private EventResponseDTO event;
    private UserResponseDTO user;
    private String invitationStatus;
    private Instant sentDate;
    private Boolean active;
}
