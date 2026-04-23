package com.jhanp.gestioneventos.service;

import com.jhanp.gestioneventos.dto.request.AccessTypeRequestDTO;
import com.jhanp.gestioneventos.dto.response.AccessTypeResponseDTO;
import com.jhanp.gestioneventos.service.interfaces.IAccessTypeService;

import java.util.List;

public class AccessTypeService implements IAccessTypeService {
    @Override
    public List<AccessTypeResponseDTO> getAllAccessTypes() {
        return List.of();
    }

    @Override
    public List<AccessTypeResponseDTO> getActiveAccessTypes() {
        return List.of();
    }

    @Override
    public List<AccessTypeResponseDTO> getInactiveAccessTypes() {
        return List.of();
    }

    @Override
    public AccessTypeResponseDTO createAccessType(AccessTypeRequestDTO accessTypeReq) {
        return null;
    }

    @Override
    public AccessTypeResponseDTO updateAccessType(AccessTypeRequestDTO accessTypeReq) {
        return null;
    }

    @Override
    public Boolean deleteAccessType(Integer id) {
        return null;
    }
}
