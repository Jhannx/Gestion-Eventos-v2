package com.jhanp.gestioneventos.service;
import com.jhanp.gestioneventos.domain.entity.EventType;
import com.jhanp.gestioneventos.dto.request.EventTypeRequestDTO;
import com.jhanp.gestioneventos.dto.response.EventTypeResponseDTO;
import com.jhanp.gestioneventos.exception.DuplicateResourceException;
import com.jhanp.gestioneventos.exception.InvalidDataException;
import com.jhanp.gestioneventos.exception.ResourceNotFoundException;
import com.jhanp.gestioneventos.mapper.Mapper;
import com.jhanp.gestioneventos.repository.entity.EventTypeRepository;
import com.jhanp.gestioneventos.service.interfaces.IEventTypeService;
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

@Service
@RequiredArgsConstructor
public class EventTypeService implements IEventTypeService {
    private static final Logger log = LoggerFactory.getLogger(EventTypeService.class);

    private final EventTypeRepository rep;

    @Override
    public List<EventTypeResponseDTO> getAllEventTypes() {
        List<EventType> eventTypeList = rep.findAll();
        return eventTypeList.stream()
                .map(Mapper::toResponseDTO)
                .toList();
    }

    @Override
    public List<EventTypeResponseDTO> getActiveEventTypes() {
        List<EventType> eventTypeList = rep.findByActiveTrue();
        return eventTypeList.stream()
                .map(Mapper::toResponseDTO)
                .toList();
    }

    @Override
    public List<EventTypeResponseDTO> getInactiveEventTypes() {
        List<EventType> eventTypeList = rep.findByActiveFalse();
        return eventTypeList.stream()
                .map(Mapper::toResponseDTO)
                .toList();
    }

    @Override
    public List<EventTypeResponseDTO> searchEventTypeById(String q) {
        log.info("Buscando tipos de evento con query: {}", q);
        return rep.searchByIdOrName(q)
                .stream()
                .map(Mapper::toResponseDTO)
                .toList();
    }

    @Override
    @Transactional
    public EventTypeResponseDTO createEventType(EventTypeRequestDTO eventTypeReq) {
        log.info("Creando tipo de evento: {}", eventTypeReq.getName());

        EventType eventType = EventType.builder()
                .name(eventTypeReq.getName())
                .description(eventTypeReq.getDescription())
                .active(eventTypeReq.getActive())
                .build();

        try {
            EventTypeResponseDTO created = Mapper.toResponseDTO(rep.save(eventType));
            log.info("Tipo de evento creado exitosamente con ID: {}", created.getId());
            return created;
        } catch (DataIntegrityViolationException e) {
            log.warn("Ya existe un tipo de evento con el nombre: {}", eventTypeReq.getName());
            throw new DuplicateResourceException(
                    "Ya existe un tipo de evento con el nombre: " + eventTypeReq.getName()
            );
        }
    }

    @Override
    @Transactional
    public EventTypeResponseDTO updateEventType(Integer id, EventTypeRequestDTO eventTypeReq) {
        log.info("Actualizando tipo de evento con ID: {}", id);

        EventType eventType = rep.findById(id).orElseThrow(() -> {
                    log.warn("Tipo de evento no encontrado con ID: {}", id);
                    return new ResourceNotFoundException("Tipo de evento no encontrado con ID: " + id);
                });

        eventType.setName(eventTypeReq.getName());
        eventType.setDescription(eventTypeReq.getDescription());
        eventType.setActive(eventTypeReq.getActive());

        EventTypeResponseDTO updated = Mapper.toResponseDTO(rep.save(eventType));
        log.info("Tipo de evento actualizado exitosamente con ID: {}", id);
        return updated;
    }

    @Override
    @Transactional
    public Boolean deleteEventType(Integer id) {
        log.info("Eliminando tipo de evento con ID: {}", id);

        if (!rep.existsById(id)) {
            log.warn("Tipo de evento no encontrado con ID: {}", id);
            throw new ResourceNotFoundException("Tipo de evento no encontrado con ID: " + id);
        }

        try {
            rep.deleteById(id);
            log.info("Tipo de evento eliminado exitosamente con ID: {}", id);

            return true;
        } catch (DataIntegrityViolationException e) {
            log.error("Error al eliminar tipo de evento con ID: {}", id);
            throw new InvalidDataException("No se puede eliminar el tipo de evento porque tiene registros asociados");
        }
    }
}
