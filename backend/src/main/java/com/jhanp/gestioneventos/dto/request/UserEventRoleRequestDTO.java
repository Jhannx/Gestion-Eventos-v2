package com.jhanp.gestioneventos.dto.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEventRoleRequestDTO {
    private Long idUser;
    private Long idEvent;
    private Long idEventRole;
}
