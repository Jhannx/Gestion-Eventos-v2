package com.jhanp.gestioneventos.service.interfaces;

import com.jhanp.gestioneventos.dto.request.EventAccessRequestDTO;
import com.jhanp.gestioneventos.dto.request.EventRequestDTO;
import com.jhanp.gestioneventos.dto.response.EventAccessResponseDTO;
import com.jhanp.gestioneventos.dto.response.EventResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IEventService {
    Page<EventResponseDTO> getAllEvents(int page, int size);
    Page<EventResponseDTO> getActiveEvents(int page, int size);
    Page<EventResponseDTO> getInactiveEvents(int page, int size);
    List<EventResponseDTO> searchEventById(String q);
    EventResponseDTO getEventById(Long id);
    EventResponseDTO createEvent(EventRequestDTO eventReq);
    EventResponseDTO updateEvent(EventRequestDTO eventReq);
    Boolean deleteEvent(Integer id);

    List<EventAccessResponseDTO> getAccessByEvent(Integer idEvent);
    EventAccessResponseDTO getAccessById(Integer idEvent, Integer idAccess);
    EventAccessResponseDTO createEventAccess(Integer idEvent, EventAccessRequestDTO eventAccessReq);
    EventAccessResponseDTO updateEventAccess(Integer idEvent, Integer idAccessType, EventAccessRequestDTO eventAccessReq);
    Boolean deleteEventAccess(Integer idEvent, Integer idAccess);

}
