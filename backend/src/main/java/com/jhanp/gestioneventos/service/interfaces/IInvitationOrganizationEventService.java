package com.jhanp.gestioneventos.service.interfaces;

import com.jhanp.gestioneventos.dto.request.InvitationOrganizationEventRequestDTO;
import com.jhanp.gestioneventos.dto.response.InvitationOrganizationEventResponseDTO;
import org.springframework.data.domain.Page;

public interface IInvitationOrganizationEventService {
    Page<InvitationOrganizationEventResponseDTO> getAllInvitationOrganizations(int page, int size);
    Page<InvitationOrganizationEventResponseDTO> getActiveInvitationOrganizations(int page, int size);
    Page<InvitationOrganizationEventResponseDTO> getInactiveInvitationOrganizations(int page, int size);
    InvitationOrganizationEventResponseDTO createOrganizationInvitation(InvitationOrganizationEventRequestDTO invitationOrganizationReq);
    InvitationOrganizationEventResponseDTO updateOrganizationInvitation(InvitationOrganizationEventRequestDTO invitationOrganizationReq);
    Boolean deleteOrganizationInvitation(Integer id);
}
