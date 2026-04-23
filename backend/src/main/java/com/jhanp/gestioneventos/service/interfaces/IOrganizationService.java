package com.jhanp.gestioneventos.service.interfaces;

import com.jhanp.gestioneventos.dto.request.OrganizationRequestDTO;
import com.jhanp.gestioneventos.dto.response.OrganizationResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IOrganizationService {
    Page<OrganizationResponseDTO> getAllOrganizations(int page, int size);
    Page<OrganizationResponseDTO> getActiveOrganizations(int page, int size);
    Page<OrganizationResponseDTO> getInactiveOrganizations(int page, int size);
    List<OrganizationResponseDTO> searchOrganizationById(String q);
    OrganizationResponseDTO createOrganization(OrganizationRequestDTO organizationReq);
    OrganizationResponseDTO updateOrganization(OrganizationRequestDTO organizationReq);
    Boolean deleteOrganization(Integer id);


}
