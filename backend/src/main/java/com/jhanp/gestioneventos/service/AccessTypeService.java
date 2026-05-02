package com.jhanp.gestioneventos.service;

import com.jhanp.gestioneventos.domain.entity.AccessType;
import com.jhanp.gestioneventos.dto.request.AccessTypeRequestDTO;
import com.jhanp.gestioneventos.dto.response.AccessTypeResponseDTO;
import com.jhanp.gestioneventos.repository.entity.AccessTypeRepository;
import com.jhanp.gestioneventos.service.interfaces.IAccessTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccessTypeService implements IAccessTypeService {
    private final AccessTypeRepository rep;
    private AccessType accessType;

    @Override
    public List<AccessTypeResponseDTO> getAllAccessTypes() {
        return null;
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
