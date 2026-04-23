package com.jhanp.gestioneventos.service.interfaces;

import com.jhanp.gestioneventos.dto.request.InvitationUserEventoRequestDTO;
import com.jhanp.gestioneventos.dto.response.InvitationUserEventResponseDTO;
import org.springframework.data.domain.Page;

public interface IInvitationUserEventService {
    Page<InvitationUserEventResponseDTO> getAllInvitationUsers(int page, int size);
    Page<InvitationUserEventResponseDTO> getActiveInvitationUsers(int page, int size);
    Page<InvitationUserEventResponseDTO> getInactiveInvitationUsers(int page, int size);
    InvitationUserEventResponseDTO createUserInvitation(InvitationUserEventoRequestDTO invitationUserReq);
    InvitationUserEventResponseDTO updateUserInvitation(InvitationUserEventoRequestDTO invitationUserReq);
    Boolean deleteUserInvitation(Integer id);
}
