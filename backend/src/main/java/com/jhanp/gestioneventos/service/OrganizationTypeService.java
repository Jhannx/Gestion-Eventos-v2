package com.jhanp.gestioneventos.service;

import com.jhanp.gestioneventos.dto.request.OrganizationTypeRequestDTO;
import com.jhanp.gestioneventos.dto.response.OrganizationTypeResponseDTO;
import com.jhanp.gestioneventos.service.interfaces.IOrganizationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationTypeService implements IOrganizationTypeService {
    @Override
    public List<OrganizationTypeResponseDTO> getAllOrganizationTypes() {
        return List.of();
    }

    @Override
    public List<OrganizationTypeResponseDTO> getOrganizationTypes() {
        return List.of();
    }

    @Override
    public OrganizationTypeResponseDTO getOrganizationTypeById(Integer id) {
        return null;
    }

    @Override
    public OrganizationTypeResponseDTO createOrganizationType(OrganizationTypeRequestDTO organizationTypeReq) {
        return null;
    }

    @Override
    public OrganizationTypeResponseDTO updateOrganizationType(OrganizationTypeRequestDTO organizationTypeReq) {
        return null;
    }

    @Override
    public Boolean deleteOrganizationType(Integer id) {
        return null;
    }
}
