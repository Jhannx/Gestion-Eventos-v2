package com.jhanp.gestioneventos.service.interfaces;

import com.jhanp.gestioneventos.dto.request.AccessTypeRequestDTO;
import com.jhanp.gestioneventos.dto.response.AccessTypeResponseDTO;

import java.util.List;

public interface IAccessTypeService {
    List<AccessTypeResponseDTO> getAllAccessTypes();
    List<AccessTypeResponseDTO> getActiveAccessTypes();
    List<AccessTypeResponseDTO> getInactiveAccessTypes();
    AccessTypeResponseDTO createAccessType(AccessTypeRequestDTO accessTypeReq);
    AccessTypeResponseDTO updateAccessType(AccessTypeRequestDTO accessTypeReq);
    Boolean deleteAccessType(Integer id);

}
