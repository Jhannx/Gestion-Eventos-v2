package com.jhanp.gestioneventos.service;

import com.jhanp.gestioneventos.domain.entity.Event;
import com.jhanp.gestioneventos.domain.entity.EventAccess;
import com.jhanp.gestioneventos.domain.view.OccupationEventView;
import com.jhanp.gestioneventos.dto.request.EventAccessRequestDTO;
import com.jhanp.gestioneventos.dto.request.EventRequestDTO;
import com.jhanp.gestioneventos.dto.response.EventAccessResponseDTO;
import com.jhanp.gestioneventos.dto.response.EventResponseDTO;
import com.jhanp.gestioneventos.exception.InvalidDataException;
import com.jhanp.gestioneventos.exception.ResourceNotFoundException;
import com.jhanp.gestioneventos.mapper.Mapper;
import com.jhanp.gestioneventos.repository.entity.*;
import com.jhanp.gestioneventos.repository.view.ActiveEventsRepository;
import com.jhanp.gestioneventos.repository.view.CancelledEventsViewRepository;
import com.jhanp.gestioneventos.repository.view.DetailEventViewRepository;
import com.jhanp.gestioneventos.repository.view.OccupationEventViewRepository;
import com.jhanp.gestioneventos.service.interfaces.IEventService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import com.jhanp.gestioneventos.repository.entity.AccessTypeRepository;
import com.jhanp.gestioneventos.repository.entity.EventAccessRepository;
import com.jhanp.gestioneventos.repository.entity.EventRepository;
import com.jhanp.gestioneventos.repository.entity.EventTypeRepository;
import com.jhanp.gestioneventos.repository.entity.OrganizationRepository;

@Service
@RequiredArgsConstructor
public class EventService implements IEventService {
    private static final Logger log = LoggerFactory.getLogger(EventService.class);

    private final EventRepository rep;
    private final EventTypeRepository eventTypeRep;
    private final OrganizationRepository organizationRep;
    private final EventAccessRepository eaRep;
    private final AccessTypeRepository accessTypeRep;

    private final ActiveEventsRepository activeEventsRep;
    private final CancelledEventsViewRepository cancelledEventsRep;
    private final DetailEventViewRepository detailEventRep;
    private final OccupationEventViewRepository occupationRep;

    // CRUD EVENTOS

    @Override
    public Page<EventResponseDTO> getAllEvents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return rep.findAll(pageable).map(Mapper::toResponseDTO);
    }

    @Override
    public Page<EventResponseDTO> getActiveEvents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return activeEventsRep.findAll(pageable).map(Mapper::toResponseDTO);
    }

    @Override
    public Page<EventResponseDTO> getInactiveEvents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return rep.findByActiveFalse(pageable).map(Mapper::toResponseDTO);
    }

    @Override
    public Page<EventResponseDTO> getCancelledEvents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return cancelledEventsRep.findAll(pageable).map(Mapper::toResponseDTO);
    }

    @Override
    public List<EventResponseDTO> searchEventById(String q) {
        return rep.findByNameContainingIgnoreCase(q)
                .stream()
                .map(Mapper::toResponseDTO)
                .toList();
    }

    @Override
    public EventResponseDTO getEventById(Integer id) {
        log.info("Buscando evento con ID: {}", id);

        Event event = rep.findById(id).orElseThrow(() -> {
            log.warn("Evento no encontrado con ID: {}", id);
            return new ResourceNotFoundException("Evento no encontrado con ID: " + id);
        });
        return Mapper.toResponseDTO(event);
    }

    @Override
    @Transactional
    public EventResponseDTO createEvent(EventRequestDTO eventReq) {
        log.info("Creando evento: {}", eventReq.getName());

        Event event = Event.builder()
                .name(eventReq.getName())
                .description(eventReq.getDescription())
                .address(eventReq.getAddress())
                .place(eventReq.getPlace())
                .date(eventReq.getDate())
                .startTime(eventReq.getStartTime())
                .endTime(eventReq.getEndTime())
                .capacity(eventReq.getCapacity())
                .accessRestriction(eventReq.getAccessRestriction())
                .eventStatus(eventReq.getEventStatus())
                .active(eventReq.getActive())
                .build();

        if (eventReq.getIdEventType() != null) {
            // Buscar y asignar tipo evento
            event.setEventType(eventTypeRep.findById(eventReq.getIdEventType()).orElseThrow(() -> {
                        log.warn("Tipo de evento no encontrado con ID: {}", eventReq.getIdEventType());
                        return new ResourceNotFoundException("Tipo de evento no encontrado con ID: " + eventReq.getIdEventType());
                    })
            );
        }

        if (eventReq.getIdOrganization() != null) {
            // Buscar y asignar organización
            event.setOrganization(
                    organizationRep.findById(eventReq.getIdOrganization()).orElseThrow(() -> {
                        log.warn("Organización no encontrada con ID: {}", eventReq.getIdOrganization());
                        return new ResourceNotFoundException("Organización no encontrada con ID: " + eventReq.getIdOrganization());
                    })
            );
        }
        EventResponseDTO created = Mapper.toResponseDTO(rep.save(event));
        log.info("Evento creado exitosamente con ID: {}", created.getId());
        return created;
    }

    @Override
    @Transactional
    public EventResponseDTO updateEvent(Integer id, EventRequestDTO eventReq) {
        log.info("Actualizando evento con ID: {}", id);

        Event event = rep.findById(id).orElseThrow(() -> {
            log.warn("Evento no encontrado con ID: {}", eventReq.getId());
            return new ResourceNotFoundException("Evento no encontrado con ID: " + eventReq.getId());
        });

        event.setName(eventReq.getName());
        event.setDescription(eventReq.getDescription());
        event.setAddress(eventReq.getAddress());
        event.setPlace(eventReq.getPlace());
        event.setDate(eventReq.getDate());
        event.setStartTime(eventReq.getStartTime());
        event.setEndTime(eventReq.getEndTime());
        event.setCapacity(eventReq.getCapacity());
        event.setAccessRestriction(eventReq.getAccessRestriction());
        event.setEventStatus(eventReq.getEventStatus());
        event.setActive(eventReq.getActive());

        if (eventReq.getIdEventType() != null) {
            // Buscar y asignar tipo de evento
            event.setEventType(eventTypeRep.findById(eventReq.getIdEventType()).orElseThrow(() ->
                            new ResourceNotFoundException("Tipo de evento no encontrado con ID: " + eventReq.getIdEventType()))
            );
        }

        if (eventReq.getIdOrganization() != null) {
            // Buscar y asignar organización
            event.setOrganization(
                    organizationRep.findById(eventReq.getIdOrganization()).orElseThrow(() ->
                            new ResourceNotFoundException("Organización no encontrada con ID: " + eventReq.getIdOrganization()))
            );
        }
        EventResponseDTO updated = Mapper.toResponseDTO(rep.save(event));
        log.info("Evento actualizado exitosamente con ID: {}", updated.getId());
        return updated;
    }

    @Override
    @Transactional
    public Boolean deleteEvent(Integer id) {
        log.info("Eliminando evento con ID: {}", id);

        if (!rep.existsById(id)) {
            log.warn("Evento no encontrado con ID: {}", id);
            throw new ResourceNotFoundException("Evento no encontrado con ID: " + id);
        }
        try {
            rep.deleteById(id);
            log.info("Evento eliminado exitosamente con ID: {}", id);
            return true;
        } catch (DataIntegrityViolationException e) {
            log.error("Error al eliminar evento con ID {}: {}", id, e.getMessage());
            throw new InvalidDataException("No se puede eliminar el evento porque tiene registros asociados");
        }
    }

    @Override
    public OccupationEventView getEventOccupation(Integer idEvent) {
        log.info("Consultando ocupación del evento con ID: {}", idEvent);

        return occupationRep.findByIdEvent(idEvent).orElseThrow(() -> {
            log.warn("Ocupación no encontrada para el evento con ID: {}", idEvent);
            return new ResourceNotFoundException("Ocupación no encontrada para el evento con ID: " + idEvent);
        });
    }

    // CRUD ACCESOS PARA EL EVENTO

    @Override
    public List<EventAccessResponseDTO> getAccessByEvent(Integer idEvent) {
        log.info("Consultando accesos del evento con ID: {}", idEvent);

        if (!rep.existsById(idEvent)) {
            log.warn("Evento no encontrado con ID: {}", idEvent);
            throw new ResourceNotFoundException("Evento no encontrado con ID: " + idEvent);
        }

        return detailEventRep.findByIdEvent(idEvent)
                .stream()
                .map(Mapper::toResponseDTO)
                .toList();
    }

    @Override
    public EventAccessResponseDTO getAccessById(Integer idEvent, Integer idAccess) {
        log.info("Consultando acceso ID: {} del evento ID: {}", idAccess, idEvent);

        EventAccess eventAccess = eaRep.findById(idAccess).orElseThrow(() -> {
            log.warn("Acceso no encontrado con ID: {}", idAccess);
            return new ResourceNotFoundException("Acceso no encontrado con ID: " + idAccess);
        });

        if (!eventAccess.getEvent().getId().equals(idEvent)) {
            log.warn("El acceso ID: {} no pertenece al evento ID: {}", idAccess, idEvent);
            throw new InvalidDataException("El acceso no pertenece al evento indicado");
        }

        return Mapper.toResponseDTO(eventAccess);
    }

    @Override
    @Transactional
    public EventAccessResponseDTO createEventAccess(Integer idEvent, EventAccessRequestDTO eventAccessReq) {
        log.info("Creando acceso para el evento ID: {}", idEvent);

        rep.findById(idEvent).orElseThrow(() -> {
            log.warn("Evento no encontrado con ID: {}", idEvent);
            return new ResourceNotFoundException("Evento no encontrado con ID: " + idEvent);
        });

        accessTypeRep.findById(eventAccessReq.getIdAccessType()).orElseThrow(() -> {
            log.warn("Tipo de acceso no encontrado con ID: {}", eventAccessReq.getIdAccessType());
            return new ResourceNotFoundException("Tipo de acceso no encontrado con ID: " + eventAccessReq.getIdAccessType());
        });

        Integer newId = eaRep.createEventAccess(
                idEvent,
                eventAccessReq.getIdAccessType(),
                eventAccessReq.getPrice(),
                eventAccessReq.getSpots()
        );

        log.info("Acceso creado exitosamente con ID: {}", newId);

        return Mapper.toResponseDTO(
                eaRep.findById(newId).orElseThrow(() -> {
                    log.error("No se pudo recuperar el acceso creado con ID: {}", newId);
                    return new ResourceNotFoundException("No se pudo recuperar el acceso creado con ID: " + newId);
                })
        );
    }

    @Override
    @Transactional
    public EventAccessResponseDTO updateEventAccess(Integer idEvent, Integer idAccess, EventAccessRequestDTO eventAccessReq) {
        log.info("Actualizando acceso ID: {} del evento ID: {}", idAccess, idEvent);

        EventAccess eventAccess = eaRep.findById(idAccess).orElseThrow(() -> {
            log.warn("Acceso no encontrado con ID: {}", idAccess);
            return new ResourceNotFoundException("Acceso no encontrado con ID: " + idAccess);
        });

        if (!eventAccess.getEvent().getId().equals(idEvent)) {
            log.warn("El acceso ID: {} no pertenece al evento ID: {}", idAccess, idEvent);
            throw new InvalidDataException("El acceso no pertenece al evento indicado");
        }

        if (eventAccessReq.getIdAccessType() != null) {
            accessTypeRep.findById(eventAccessReq.getIdAccessType()).ifPresentOrElse(
                    eventAccess::setAccessType,
                    () -> { throw new ResourceNotFoundException("Tipo de acceso no encontrado con ID: " + eventAccessReq.getIdAccessType()); }
            );
        }

        eventAccess.setPrice(eventAccessReq.getPrice());
        eventAccess.setSpots(eventAccessReq.getSpots());
        eventAccess.setAccessStatus(eventAccessReq.getAccessStatus());
        eventAccess.setActive(eventAccessReq.getActive());

        EventAccessResponseDTO updated = Mapper.toResponseDTO(eaRep.save(eventAccess));
        log.info("Acceso actualizado exitosamente con ID: {}", idAccess);
        return updated;
    }

    @Override
    @Transactional
    public Boolean deleteEventAccess(Integer idEvent, Integer idAccess) {
        log.info("Eliminando acceso ID: {} del evento ID: {}", idAccess, idEvent);

        EventAccess eventAccess = eaRep.findById(idAccess).orElseThrow(() -> {
            log.warn("Acceso no encontrado con ID: {}", idAccess);
            return new ResourceNotFoundException("Acceso no encontrado con ID: " + idAccess);
        });

        if (!eventAccess.getEvent().getId().equals(idEvent)) {
            log.warn("El acceso ID: {} no pertenece al evento ID: {}", idAccess, idEvent);
            throw new InvalidDataException("El acceso no pertenece al evento indicado");
        }

        try {
            eaRep.deleteById(idAccess);
            log.info("Acceso eliminado exitosamente con ID: {}", idAccess);
            return true;
        } catch (DataIntegrityViolationException e) {
            log.error("Error al eliminar acceso ID {}: {}", idAccess, e.getMessage());
            throw new InvalidDataException("No se puede eliminar el acceso porque tiene inscripciones asociadas");
        }
    }
}

