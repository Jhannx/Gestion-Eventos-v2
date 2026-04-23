package com.jhanp.gestioneventos.service.interfaces;

import com.jhanp.gestioneventos.dto.request.EventTypeRequestDTO;
import com.jhanp.gestioneventos.dto.response.EventTypeResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IEventTypeService {
    Page<EventTypeResponseDTO> getAllEventTypes(int page, int size);
    Page<EventTypeResponseDTO> getActiveEventTypes(int page, int size);
    Page<EventTypeResponseDTO> getInactiveEventTypes(int page, int size);
    List<EventTypeResponseDTO> searchEventTypeById(String q);
    EventTypeResponseDTO createEventType(EventTypeRequestDTO eventTypeReq);
    EventTypeResponseDTO updateEventType(EventTypeRequestDTO eventTypeReq);
    Boolean deleteEventType(Integer id);
}
