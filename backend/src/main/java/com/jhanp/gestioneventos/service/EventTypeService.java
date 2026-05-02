package com.jhanp.gestioneventos.service;

import com.jhanp.gestioneventos.dto.request.EventTypeRequestDTO;
import com.jhanp.gestioneventos.dto.response.EventTypeResponseDTO;
import com.jhanp.gestioneventos.service.interfaces.IEventTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventTypeService implements IEventTypeService {
    @Override
    public Page<EventTypeResponseDTO> getAllEventTypes(int page, int size) {
        return null;
    }

    @Override
    public Page<EventTypeResponseDTO> getActiveEventTypes(int page, int size) {
        return null;
    }

    @Override
    public Page<EventTypeResponseDTO> getInactiveEventTypes(int page, int size) {
        return null;
    }

    @Override
    public List<EventTypeResponseDTO> searchEventTypeById(String q) {
        return List.of();
    }

    @Override
    public EventTypeResponseDTO createEventType(EventTypeRequestDTO eventTypeReq) {
        return null;
    }

    @Override
    public EventTypeResponseDTO updateEventType(EventTypeRequestDTO eventTypeReq) {
        return null;
    }

    @Override
    public Boolean deleteEventType(Integer id) {
        return null;
    }
}
