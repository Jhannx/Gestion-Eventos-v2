package com.jhanp.gestioneventos.service;

import com.jhanp.gestioneventos.dto.request.EventRoleRequestDTO;
import com.jhanp.gestioneventos.dto.response.EventRoleResponseDTO;
import com.jhanp.gestioneventos.service.interfaces.IEventRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventRoleService implements IEventRoleService {
    @Override
    public List<EventRoleResponseDTO> getAllEventoRoles() {
        return List.of();
    }

    @Override
    public List<EventRoleResponseDTO> getActiveEventoRoles() {
        return List.of();
    }

    @Override
    public List<EventRoleResponseDTO> getInactiveEventoRoles() {
        return List.of();
    }

    @Override
    public EventRoleResponseDTO createEventRole(EventRoleRequestDTO eventRoleReq) {
        return null;
    }

    @Override
    public EventRoleResponseDTO updateEventRole(EventRoleRequestDTO eventRoleReq) {
        return null;
    }

    @Override
    public Boolean deleteEventRole(Integer id) {
        return null;
    }
}
