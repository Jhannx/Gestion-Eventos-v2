package com.jhanp.gestioneventos.service;

import com.jhanp.gestioneventos.dto.request.InvitationOrganizationEventRequestDTO;
import com.jhanp.gestioneventos.dto.response.InvitationOrganizationEventResponseDTO;
import com.jhanp.gestioneventos.service.interfaces.IInvitationOrganizationEventService;
import org.springframework.data.domain.Page;

public class InvitationOrganizationEventService implements IInvitationOrganizationEventService {
    @Override
    public Page<InvitationOrganizationEventResponseDTO> getAllInvitationOrganizations(int page, int size) {
        return null;
    }

    @Override
    public Page<InvitationOrganizationEventResponseDTO> getActiveInvitationOrganizations(int page, int size) {
        return null;
    }

    @Override
    public Page<InvitationOrganizationEventResponseDTO> getInactiveInvitationOrganizations(int page, int size) {
        return null;
    }

    @Override
    public InvitationOrganizationEventResponseDTO createOrganizationInvitation(InvitationOrganizationEventRequestDTO invitationOrganizationReq) {
        return null;
    }

    @Override
    public InvitationOrganizationEventResponseDTO updateOrganizationInvitation(InvitationOrganizationEventRequestDTO invitationOrganizationReq) {
        return null;
    }

    @Override
    public Boolean deleteOrganizationInvitation(Integer id) {
        return null;
    }
}
