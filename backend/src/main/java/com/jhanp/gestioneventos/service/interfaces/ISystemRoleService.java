package com.jhanp.gestioneventos.service.interfaces;

import com.jhanp.gestioneventos.dto.request.SystemRoleRequestDTO;
import com.jhanp.gestioneventos.dto.response.SystemRoleResponseDTO;

import java.util.List;

public interface ISystemRoleService {
    List<SystemRoleResponseDTO> getAllSystemRoles();
    List<SystemRoleResponseDTO> getActivesSystemRoles();
    SystemRoleResponseDTO getSystemRoleById(Integer id);
    SystemRoleResponseDTO createSystemRole(SystemRoleRequestDTO systemRoleReq);
    SystemRoleResponseDTO updateSystemRole(Integer id, SystemRoleRequestDTO systemRoleRequestDTO);
    Boolean deleteSystemRole(Integer id);

}
