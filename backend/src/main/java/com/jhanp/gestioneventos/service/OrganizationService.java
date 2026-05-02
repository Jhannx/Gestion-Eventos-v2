package com.jhanp.gestioneventos.service;

import com.jhanp.gestioneventos.dto.request.OrganizationRequestDTO;
import com.jhanp.gestioneventos.dto.response.OrganizationResponseDTO;
import com.jhanp.gestioneventos.service.interfaces.IOrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationService implements IOrganizationService {
    @Override
    public Page<OrganizationResponseDTO> getAllOrganizations(int page, int size) {
        return null;
    }

    @Override
    public Page<OrganizationResponseDTO> getActiveOrganizations(int page, int size) {
        return null;
    }

    @Override
    public Page<OrganizationResponseDTO> getInactiveOrganizations(int page, int size) {
        return null;
    }

    @Override
    public List<OrganizationResponseDTO> searchOrganizationById(String q) {
        return List.of();
    }

    @Override
    public OrganizationResponseDTO createOrganization(OrganizationRequestDTO organizationReq) {
        return null;
    }

    @Override
    public OrganizationResponseDTO updateOrganization(OrganizationRequestDTO organizationReq) {
        return null;
    }

    @Override
    public Boolean deleteOrganization(Integer id) {
        return null;
    }
}
