package com.jhanp.gestioneventos.dto.response;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSystemRoleResponseDTO {
    private Long idUserSystemRole;
    private UserResponseDTO user;
    private SystemRoleResponseDTO systemRole;
}
