package com.jhanp.gestioneventos.service.interfaces;

import com.jhanp.gestioneventos.dto.request.EventTypeRequestDTO;
import com.jhanp.gestioneventos.dto.response.EventTypeResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IEventTypeService {
    List<EventTypeResponseDTO> getAllEventTypes();
    List<EventTypeResponseDTO> getActiveEventTypes();
    List<EventTypeResponseDTO> getInactiveEventTypes();
    List<EventTypeResponseDTO> searchEventTypeById(String q);
    EventTypeResponseDTO createEventType(EventTypeRequestDTO eventTypeReq);
    EventTypeResponseDTO updateEventType(Integer id, EventTypeRequestDTO eventTypeReq);
    Boolean deleteEventType(Integer id);
}
