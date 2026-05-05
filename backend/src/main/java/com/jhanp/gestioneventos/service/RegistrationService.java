package com.jhanp.gestioneventos.service;

import com.jhanp.gestioneventos.domain.entity.EventRole;
import com.jhanp.gestioneventos.domain.entity.Registration;
import com.jhanp.gestioneventos.domain.entity.User;
import com.jhanp.gestioneventos.domain.view.UserRegistrationsView;
import com.jhanp.gestioneventos.dto.request.EventRoleRequestDTO;
import com.jhanp.gestioneventos.dto.request.RegistrationRequestDTO;
import com.jhanp.gestioneventos.dto.response.EventAccessResponseDTO;
import com.jhanp.gestioneventos.dto.response.EventRoleResponseDTO;
import com.jhanp.gestioneventos.dto.response.RegistrationResponseDTO;
import com.jhanp.gestioneventos.exception.InvalidDataException;
import com.jhanp.gestioneventos.exception.ResourceNotFoundException;
import com.jhanp.gestioneventos.mapper.Mapper;
import com.jhanp.gestioneventos.repository.entity.EventRoleRepository;
import com.jhanp.gestioneventos.repository.entity.RegistrationRepository;
import com.jhanp.gestioneventos.repository.entity.UserRepository;
import com.jhanp.gestioneventos.repository.view.AvailableAccessViewRepository;
import com.jhanp.gestioneventos.repository.view.UserRegistrationsViewRepository;
import com.jhanp.gestioneventos.service.interfaces.IRegistrationService;
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
public class RegistrationService implements IRegistrationService {
    private static final Logger log = LoggerFactory.getLogger(RegistrationService.class);

    private final RegistrationRepository rep;
    private final UserRegistrationsViewRepository userRegistrationsRep;
    private final AvailableAccessViewRepository availableAccessRep;
    private final EventRoleRepository eventRoleRep;
    private final UserRepository userRep;

    @Override
    public List<EventAccessResponseDTO> getAccessByEvent(Integer idEvent) {
        log.info("Obteniendo accesos disponibles para el evento con ID: {}", idEvent);
        return availableAccessRep.findByIdEvent(idEvent)
                .stream()
                .map(Mapper::toResponseDTO)
                .toList();
    }

    @Override
    public List<UserRegistrationsView> findRegistrationsByUserIdentificationNumber(String userIdentification) {
        log.info("Buscando inscripciones para identificación: {}", userIdentification);

        User user = userRep.findByIdentificationNumber(userIdentification).orElseThrow(() -> {
            log.warn("Usuario no encontrado con identificación: {}", userIdentification);
            return new ResourceNotFoundException("Usuario no encontrado con identificación: " + userIdentification);
        });

        return userRegistrationsRep.findByUserIdentification(user.getIdentificationNumber(), Pageable.unpaged()).getContent();
    }

    @Override
    public Page<RegistrationResponseDTO> getAllRegistrations(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return rep.findAll(pageable).map(Mapper::toResponseDTO);
    }

    @Override
    public Page<RegistrationResponseDTO> getActiveRegistrations(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return rep.findByActiveTrue(pageable).map(Mapper::toResponseDTO);
    }

    @Override
    public Page<RegistrationResponseDTO> getInactiveRegistrations(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return rep.findByActiveFalse(pageable).map(Mapper::toResponseDTO);
    }

    @Override
    public RegistrationResponseDTO getRegistrationById(Integer id) {
        log.info("Buscando inscripción con ID: {}", id);
        Registration registration = rep.findById(id).orElseThrow(() -> {
            log.warn("Inscripción no encontrada con ID: {}", id);
            return new ResourceNotFoundException("Inscripción no encontrada con ID: " + id);
        });
        return Mapper.toResponseDTO(registration);
    }

    @Override
    @Transactional
    public RegistrationResponseDTO createRegistration(RegistrationRequestDTO registrationReq) {
        log.info("Creando inscripción para usuario ID: {} en acceso ID: {}",
                registrationReq.getIdUser(), registrationReq.getIdEventAccess());
        try {
            Integer idRegistration = rep.registerUserToEvent(
                    registrationReq.getIdUser(),
                    registrationReq.getIdEventAccess()
            );

            Registration registration = rep.findById(idRegistration).orElseThrow(() -> {
                log.warn("No se pudo recuperar la inscripción creada con ID: {}", idRegistration);
                return new ResourceNotFoundException(
                        "No se pudo recuperar la inscripción creada con ID: " + idRegistration);
            });

            log.info("Inscripción creada exitosamente con ID: {}", idRegistration);
            return Mapper.toResponseDTO(registration);

        } catch (Exception e) {
            log.error("Error al crear inscripción: {}", e.getMessage());
            throw new RuntimeException("No se pudo completar la inscripción: " + e.getMessage());
        }
    }

    // Renombrado de updateRegistration → upgradeRegistration para cumplir la interfaz
    @Override
    @Transactional
    public RegistrationResponseDTO updateRegistration(Integer id, RegistrationRequestDTO registrationReq) {
        log.info("Actualizando inscripción con ID: {}", id);

        Registration registration = rep.findById(id).orElseThrow(() -> {
            log.warn("Inscripción no encontrada con ID: {}", id);
            return new ResourceNotFoundException("Inscripción no encontrada con ID: " + id);
        });

        registration.setRegistrationStatus(registrationReq.getRegistrationStatus());
        registration.setAttendance(registrationReq.getAttendance());
        registration.setActive(registrationReq.getActive());

        Registration updated = rep.save(registration);
        log.info("Inscripción actualizada con ID: {}", updated.getId());
        return Mapper.toResponseDTO(updated);
    }

    // Usa sp_cancelar_inscripcion: actualiza estado a CANCELADA y dispara T8 (restaura cupos)
    @Override
    @Transactional
    public Boolean deleteRegistration(Integer id) {
        log.info("Cancelando inscripción con ID: {}", id);

        if (!rep.existsById(id)) {
            log.warn("Inscripción no encontrada con ID: {}", id);
            throw new ResourceNotFoundException("Inscripción no encontrada con ID: " + id);
        }

        try {
            rep.cancelEventRegistration(id);
            log.info("Inscripción cancelada exitosamente con ID: {}", id);
            return true;
        } catch (Exception e) {
            log.error("Error al cancelar inscripción: {}", e.getMessage());
            throw new RuntimeException("No se pudo cancelar la inscripción: " + e.getMessage());
        }
    }

    @Override
    public List<EventRoleResponseDTO> getAllEventRoles() {
        log.info("Obteniendo todos los roles de evento");
        return eventRoleRep.findAll().stream().map(Mapper::toResponseDTO).toList();
    }

    @Override
    @Transactional
    public EventRoleResponseDTO createEventRole(EventRoleRequestDTO eventRoleReq) {
        log.info("Creando rol de evento: {}", eventRoleReq.getName());

        EventRole eventRole = EventRole.builder()
                .name(eventRoleReq.getName())
                .description(eventRoleReq.getDescription())
                .active(eventRoleReq.getActive())
                .build();

        EventRoleResponseDTO created = Mapper.toResponseDTO(eventRoleRep.save(eventRole));
        log.info("Rol de evento creado exitosamente con ID: {}", created.getId());
        return created;
    }

    @Override
    @Transactional
    public EventRoleResponseDTO updateEventRole(EventRoleRequestDTO eventRoleReq) {
        log.info("Actualizando rol de evento con ID: {}", eventRoleReq.getId());

        EventRole eventRole = eventRoleRep.findById(eventRoleReq.getId()).orElseThrow(() -> {
            log.warn("Rol de evento no encontrado con ID: {}", eventRoleReq.getId());
            return new ResourceNotFoundException("Rol de evento no encontrado con ID: " + eventRoleReq.getId());
        });

        eventRole.setName(eventRoleReq.getName());
        eventRole.setDescription(eventRoleReq.getDescription());
        eventRole.setActive(eventRoleReq.getActive());

        EventRoleResponseDTO updated = Mapper.toResponseDTO(eventRoleRep.save(eventRole));
        log.info("Rol de evento actualizado exitosamente con ID: {}", updated.getId());
        return updated;
    }

    @Override
    @Transactional
    public Boolean deleteEventRole(Integer id) {
        log.info("Eliminando rol de evento con ID: {}", id);

        if (!eventRoleRep.existsById(id)) {
            log.warn("Rol de evento no encontrado con ID: {}", id);
            throw new ResourceNotFoundException("Rol de evento no encontrado con ID: " + id);
        }
        try {
            eventRoleRep.deleteById(id);
            log.info("Rol de evento eliminado exitosamente con ID: {}", id);
            return true;
        } catch (DataIntegrityViolationException e) {
            log.error("Error al eliminar rol de evento con ID {}: {}", id, e.getMessage());
            throw new InvalidDataException("No se puede eliminar el rol porque tiene usuarios asignados");
        }
    }

}
