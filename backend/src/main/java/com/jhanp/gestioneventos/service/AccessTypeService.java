package com.jhanp.gestioneventos.service;

import com.jhanp.gestioneventos.domain.entity.AccessType;
import com.jhanp.gestioneventos.domain.entity.Event;
import com.jhanp.gestioneventos.domain.entity.EventAccess;
import com.jhanp.gestioneventos.dto.request.AccessTypeRequestDTO;
import com.jhanp.gestioneventos.dto.request.EventAccessRequestDTO;
import com.jhanp.gestioneventos.dto.response.AccessTypeResponseDTO;
import com.jhanp.gestioneventos.exception.DuplicateResourceException;
import com.jhanp.gestioneventos.exception.InvalidDataException;
import com.jhanp.gestioneventos.exception.ResourceNotFoundException;
import com.jhanp.gestioneventos.mapper.Mapper;
import com.jhanp.gestioneventos.repository.entity.AccessTypeRepository;
import com.jhanp.gestioneventos.repository.entity.EventAccessRepository;
import com.jhanp.gestioneventos.repository.entity.EventRepository;
import com.jhanp.gestioneventos.service.interfaces.IAccessTypeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccessTypeService implements IAccessTypeService {
    private static final Logger log = LoggerFactory.getLogger(AccessTypeService.class);

    private final AccessTypeRepository rep;
    private final EventAccessRepository eaRep;
    private final EventRepository eventRep;

    @Override
    public List<AccessTypeResponseDTO> getAllAccessTypes() {
        List<AccessType> accessTypeList = rep.findAll();
        return accessTypeList.stream().map(Mapper::toResponseDTO).toList();
    }

    @Override
    public List<AccessTypeResponseDTO> getActiveAccessTypes() {
        List<AccessType> accessTypeList = rep.findByActiveTrue();
        return accessTypeList.stream().map(Mapper::toResponseDTO).toList();
    }

    @Override
    public List<AccessTypeResponseDTO> getInactiveAccessTypes() {
        List<AccessType> accessTypeList = rep.findByActiveFalse();
        return accessTypeList.stream().map(Mapper::toResponseDTO).toList();
    }

    @Override
    @Transactional
    public AccessTypeResponseDTO createAccessType(AccessTypeRequestDTO accessTypeReq) {
        log.info("Creando tipo de acceso: {}", accessTypeReq.getName());

        // Validación de duplicados
        if (rep.existsByName(accessTypeReq.getName())) {
            log.warn("Intento de duplicado para el nombre: {}", accessTypeReq.getName());
            throw new DuplicateResourceException("Error con duplicación de datos: " + accessTypeReq.getName());
        }

        AccessType accessType = AccessType.builder()
                .name(accessTypeReq.getName())
                .description(accessTypeReq.getDescription())
                .active(accessTypeReq.getActive())
                .build();

        AccessTypeResponseDTO create = Mapper.toResponseDTO(rep.save(accessType));
        log.info("Tipo de acceso creado exitosamente");
        return create;
    }

    @Override
    @Transactional
    public AccessTypeResponseDTO updateAccessType(Integer id, AccessTypeRequestDTO accessTypeReq) {
        log.info("Actualizando tipo de acceso con ID: {}", id);

        // Buscar tipo de acceso a actualizar
        AccessType accessType = rep.findById(id).orElseThrow(() -> {
            log.warn("Tipo de acceso no encontrado con ID: {}", id);
            return new ResourceNotFoundException("Tipo de acceso no encontrado con ID: " + id);
        });

        accessType.setName(accessTypeReq.getName());
        accessType.setDescription(accessTypeReq.getDescription());
        accessType.setActive(accessTypeReq.getActive());

        if (accessTypeReq.getEventAccesses() != null && !accessTypeReq.getEventAccesses().isEmpty()) {

            if (accessType.getEventAccesses() == null) {
                accessType.setEventAccesses(new ArrayList<>());
            } else {
                accessType.getEventAccesses().clear();
            }

            List<EventAccess> updatedEventAccesses = accessType.getEventAccesses();

            for (EventAccessRequestDTO eventAccessRequestDTO : accessTypeReq.getEventAccesses()) {
                // Buscar acceso evento existente
                EventAccess eventAccess = eaRep.findById(eventAccessRequestDTO.getId()).orElseThrow(() -> {
                    log.warn("Acceso evento no encontrado con el id {}", eventAccessRequestDTO.getId());
                    return new ResourceNotFoundException(
                            "Evento acceso no encontrado con el id " + eventAccessRequestDTO.getId()
                    );
                });
                // Buscar evento del acceso existente
                Event event = eventRep.findById(eventAccessRequestDTO.getIdEvent()).orElseThrow(() -> {
                    log.warn("Evento no encontrado con ID: {}", eventAccessRequestDTO.getIdEvent());
                    return new ResourceNotFoundException(
                            "Evento no encontrado con ID: " + eventAccessRequestDTO.getIdEvent()
                    );
                });
                // Asignar a la lista de accesos a eventos actualizados

                eventAccess.setPrice(eventAccessRequestDTO.getPrice());
                eventAccess.setSpots(eventAccessRequestDTO.getSpots());
                eventAccess.setAccessStatus(eventAccessRequestDTO.getAccessStatus());
                eventAccess.setActive(eventAccessRequestDTO.getActive());
                eventAccess.setAccessType(accessType);
                eventAccess.setEvent(event);

                updatedEventAccesses.add(eventAccess);
            }
        }

        AccessTypeResponseDTO update = Mapper.toResponseDTO(rep.save(accessType));
        log.info("Tipo de acceso actualizado exitosamente con ID: {}", id);
        return update;
    }

    @Override
    @Transactional
    public Boolean deleteAccessType(Integer id) {
        log.info("Eliminando tipo de acceso con ID: {}", id);

        if (!rep.existsById(id)) {
            log.warn("Tipo de acceso no encontrado con ID: {}", id);
            throw new ResourceNotFoundException("Tipo de acceso no encontrado con ID: " + id);
        }

        try {
            rep.deleteById(id);
            log.info("Tipo de acceso eliminado exitosamente con ID: {}", id);

            return true;
        } catch (DataIntegrityViolationException e) {
            log.error("Error al eliminar tipo de acceso con ID: {}", e.getMessage());
            throw new InvalidDataException("No se puede eliminar el tipo de acceso porque tiene registros asociados");
        }
    }
}
