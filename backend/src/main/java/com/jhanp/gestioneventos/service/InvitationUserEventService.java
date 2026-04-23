package com.jhanp.gestioneventos.service;

import com.jhanp.gestioneventos.dto.request.InvitationUserEventoRequestDTO;
import com.jhanp.gestioneventos.dto.response.InvitationUserEventResponseDTO;
import com.jhanp.gestioneventos.service.interfaces.IInvitationUserEventService;
import org.springframework.data.domain.Page;

public class InvitationUserEventService implements IInvitationUserEventService {
    @Override
    public Page<InvitationUserEventResponseDTO> getAllInvitationUsers(int page, int size) {
        return null;
    }

    @Override
    public Page<InvitationUserEventResponseDTO> getActiveInvitationUsers(int page, int size) {
        return null;
    }

    @Override
    public Page<InvitationUserEventResponseDTO> getInactiveInvitationUsers(int page, int size) {
        return null;
    }

    @Override
    public InvitationUserEventResponseDTO createUserInvitation(InvitationUserEventoRequestDTO invitationUserReq) {
        return null;
    }

    @Override
    public InvitationUserEventResponseDTO updateUserInvitation(InvitationUserEventoRequestDTO invitationUserReq) {
        return null;
    }

    @Override
    public Boolean deleteUserInvitation(Integer id) {
        return null;
    }
}
