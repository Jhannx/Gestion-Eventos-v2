package com.jhanp.gestioneventos.dto.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSystemRoleRequestDTO {
    private Integer id;
    private Integer idUser;
    private Integer idSystemRole;
}

