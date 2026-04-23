package com.jhanp.gestioneventos.dto.response;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEventRoleResponseDTO {
    private Long id;
    private UserResponseDTO user;
    private EventResponseDTO event;
    private EventRoleResponseDTO eventRole;
    private Boolean active;
}
