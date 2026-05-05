package com.jhanp.gestioneventos.service.interfaces;

import com.jhanp.gestioneventos.domain.view.OccupationEventView;
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
    Page<EventResponseDTO> getCancelledEvents(int page, int size);
    List<EventResponseDTO> searchEventById(String q);
    EventResponseDTO getEventById(Integer id);
    EventResponseDTO createEvent(EventRequestDTO eventReq);
    EventResponseDTO updateEvent(Integer id, EventRequestDTO eventReq);
    Boolean deleteEvent(Integer id);

    OccupationEventView getEventOccupation(Integer idEvent);         // <-- nueva

    List<EventAccessResponseDTO> getAccessByEvent(Integer idEvent);
    EventAccessResponseDTO getAccessById(Integer idEvent, Integer idAccess);
    EventAccessResponseDTO createEventAccess(Integer idEvent, EventAccessRequestDTO eventAccessReq);
    EventAccessResponseDTO updateEventAccess(Integer idEvent, Integer idAccess, EventAccessRequestDTO eventAccessReq);
    Boolean deleteEventAccess(Integer idEvent, Integer idAccess);

}

