package com.jhanp.gestioneventos.service;

import com.jhanp.gestioneventos.dto.request.EventAccessRequestDTO;
import com.jhanp.gestioneventos.dto.request.EventRequestDTO;
import com.jhanp.gestioneventos.dto.response.EventAccessResponseDTO;
import com.jhanp.gestioneventos.dto.response.EventResponseDTO;
import com.jhanp.gestioneventos.service.interfaces.IEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService implements IEventService {

    @Override
    public Page<EventResponseDTO> getAllEvents(int page, int size) {
        return null;
    }

    @Override
    public Page<EventResponseDTO> getActiveEvents(int page, int size) {
        return null;
    }

    @Override
    public Page<EventResponseDTO> getInactiveEvents(int page, int size) {
        return null;
    }

    @Override
    public List<EventResponseDTO> searchEventById(String q) {
        return List.of();
    }

    @Override
    public EventResponseDTO getEventById(Integer id) {
        return null;
    }

    @Override
    public EventResponseDTO createEvent(EventRequestDTO eventReq) {
        return null;
    }

    @Override
    public EventResponseDTO updateEvent(EventRequestDTO eventReq) {
        return null;
    }

    @Override
    public Boolean deleteEvent(Integer id) {
        return null;
    }

    @Override
    public List<EventAccessResponseDTO> getAccessByEvent(Integer idEvent) {
        return List.of();
    }

    @Override
    public EventAccessResponseDTO getAccessById(Integer idEvent, Integer idAccess) {
        return null;
    }

    @Override
    public EventAccessResponseDTO createEventAccess(Integer idEvent, EventAccessRequestDTO eventAccessReq) {
        return null;
    }

    @Override
    public EventAccessResponseDTO updateEventAccess(Integer idEvent, Integer idAccessType, EventAccessRequestDTO eventAccessReq) {
        return null;
    }

    @Override
    public Boolean deleteEventAccess(Integer idEvent, Integer idAccess) {
        return null;
    }
}

