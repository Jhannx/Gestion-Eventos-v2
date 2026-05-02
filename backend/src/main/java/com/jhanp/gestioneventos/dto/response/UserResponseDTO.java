package com.jhanp.gestioneventos.dto.response;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {
    private Long idUser;
    private String typeIdentification;
    private String numberIdentification;
    private String name;
    private String lastName;
    private String secondLastName;
    private String phone;
    private String email;

    private List<UserOrganizationResponseDTO> organizations;
    private List<InvitationUserEventResponseDTO> invitations;
    private List<UserSystemRoleResponseDTO> userSystemRoles;
    private List<RegistrationResponseDTO> registrations;

    private Boolean active;

}
