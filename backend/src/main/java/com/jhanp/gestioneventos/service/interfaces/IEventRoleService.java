package com.jhanp.gestioneventos.service.interfaces;

import com.jhanp.gestioneventos.dto.request.EventRoleRequestDTO;
import com.jhanp.gestioneventos.dto.response.EventRoleResponseDTO;

import java.util.List;

public interface IEventRoleService {
    List<EventRoleResponseDTO> getAllEventoRoles();
    List<EventRoleResponseDTO> getActiveEventoRoles();
    List<EventRoleResponseDTO> getInactiveEventoRoles();
    EventRoleResponseDTO createEventRole(EventRoleRequestDTO eventRoleReq);
    EventRoleResponseDTO updateEventRole(EventRoleRequestDTO eventRoleReq);
    Boolean deleteEventRole(Integer id);

}
