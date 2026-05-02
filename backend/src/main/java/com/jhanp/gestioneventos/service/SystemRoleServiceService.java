package com.jhanp.gestioneventos.service;

import com.jhanp.gestioneventos.dto.request.SystemRoleRequestDTO;
import com.jhanp.gestioneventos.dto.response.SystemRoleResponseDTO;
import com.jhanp.gestioneventos.service.interfaces.ISystemRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SystemRoleServiceService implements ISystemRoleService {
    @Override
    public List<SystemRoleResponseDTO> getAllSystemRoles() {
        return List.of();
    }

    @Override
    public List<SystemRoleResponseDTO> getActivesSystemRoles() {
        return List.of();
    }

    @Override
    public SystemRoleResponseDTO getSystemRoleById(Integer id) {
        return null;
    }

    @Override
    public SystemRoleResponseDTO createSystemRole(SystemRoleRequestDTO systemRoleReq) {
        return null;
    }

    @Override
    public SystemRoleResponseDTO updateSystemRole(SystemRoleRequestDTO systemRoleRequestDTO) {
        return null;
    }

    @Override
    public Boolean deleteSystemRole(Integer id) {
        return null;
    }
}
