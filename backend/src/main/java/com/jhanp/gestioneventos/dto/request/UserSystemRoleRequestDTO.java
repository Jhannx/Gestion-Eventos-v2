package com.jhanp.gestioneventos.dto.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSystemRoleRequestDTO {
    private Long idUser;
    private Long idSystemRole;
}
