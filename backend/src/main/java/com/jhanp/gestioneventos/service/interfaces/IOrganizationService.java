package com.jhanp.gestioneventos.service.interfaces;

import com.jhanp.gestioneventos.domain.view.EventsByOrganizationView;
import com.jhanp.gestioneventos.domain.view.UsersByOrganizationView;
import com.jhanp.gestioneventos.dto.request.OrganizationRequestDTO;
import com.jhanp.gestioneventos.dto.response.OrganizationResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrganizationService {
    Page<OrganizationResponseDTO> getAllOrganizations(int page, int size);
    Page<OrganizationResponseDTO> getActiveOrganizations(int page, int size);
    Page<OrganizationResponseDTO> getInactiveOrganizations(int page, int size);
    Page<UsersByOrganizationView> getUsersByOrganization(Integer idOrganization, Pageable pageable);
    Page<EventsByOrganizationView> getEventsByOrganization(Integer idOrganization, Pageable pageable);
    Page<UsersByOrganizationView> getOrganizationByUser(Integer idUser, Pageable pageable);
    List<OrganizationResponseDTO> searchOrganizationByIdentificationNumber(String q);
    OrganizationResponseDTO createOrganization(OrganizationRequestDTO organizationReq);
    OrganizationResponseDTO updateOrganization(Integer id, OrganizationRequestDTO organizationReq);
    Boolean deleteOrganization(Integer id);


}
