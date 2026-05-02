package com.jhanp.gestioneventos.dto.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEventRoleRequestDTO {
    private Integer idUser;
    private Integer idEvent;
    private Integer idEventRole;
}

