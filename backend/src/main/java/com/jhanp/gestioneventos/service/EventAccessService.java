package com.jhanp.gestioneventos.service;

import com.jhanp.gestioneventos.dto.request.EventAccessRequestDTO;
import com.jhanp.gestioneventos.dto.response.EventAccessResponseDTO;
import com.jhanp.gestioneventos.service.interfaces.IEventAccessService;
import org.springframework.data.domain.Page;

public class EventAccessService implements IEventAccessService {
    @Override
    public Page<EventAccessResponseDTO> getAccess(int page, int size) {
        return null;
    }

    @Override
    public EventAccessResponseDTO getAccessById(Integer id) {
        return null;
    }

    @Override
    public EventAccessResponseDTO createAccess(EventAccessRequestDTO eventAccessReq) {
        return null;
    }

    @Override
    public EventAccessResponseDTO updateAccess(Integer id, EventAccessRequestDTO eventAccessReq) {
        return null;
    }

    @Override
    public boolean deleteAccess(Integer id) {
        return false;
    }
}
