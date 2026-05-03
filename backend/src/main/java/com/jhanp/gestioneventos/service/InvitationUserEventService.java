package com.jhanp.gestioneventos.service;

import com.jhanp.gestioneventos.dto.request.InvitationUserEventRequestDTO;
import com.jhanp.gestioneventos.dto.response.InvitationUserEventResponseDTO;
import com.jhanp.gestioneventos.service.interfaces.IInvitationUserEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
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
    public InvitationUserEventResponseDTO createUserInvitation(InvitationUserEventRequestDTO invitationUserReq) {
        return null;
    }

    @Override
    public InvitationUserEventResponseDTO updateUserInvitation(InvitationUserEventRequestDTO invitationUserReq) {
        return null;
    }

    @Override
    public Boolean deleteUserInvitation(Integer id) {
        return null;
    }
}
