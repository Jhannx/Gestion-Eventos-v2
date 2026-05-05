package com.jhanp.gestioneventos.service.interfaces;

import com.jhanp.gestioneventos.dto.request.OrganizationTypeRequestDTO;
import com.jhanp.gestioneventos.dto.response.OrganizationTypeResponseDTO;

import java.util.List;

public interface IOrganizationTypeService {
    List<OrganizationTypeResponseDTO> getAllOrganizationTypes();
    OrganizationTypeResponseDTO getOrganizationTypeById(Integer id);
    OrganizationTypeResponseDTO createOrganizationType(OrganizationTypeRequestDTO organizationTypeReq);
    OrganizationTypeResponseDTO updateOrganizationType(Integer id, OrganizationTypeRequestDTO organizationTypeReq);
    Boolean deleteOrganizationType(Integer id);

}
