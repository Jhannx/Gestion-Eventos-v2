package com.jhanp.gestioneventos.service;

import com.jhanp.gestioneventos.domain.entity.Event;
import com.jhanp.gestioneventos.domain.entity.InvitationUserEvent;
import com.jhanp.gestioneventos.domain.entity.User;
import com.jhanp.gestioneventos.dto.request.InvitationUserEventRequestDTO;
import com.jhanp.gestioneventos.dto.response.InvitationUserEventResponseDTO;
import com.jhanp.gestioneventos.exception.ResourceNotFoundException;
import com.jhanp.gestioneventos.mapper.Mapper;
import com.jhanp.gestioneventos.repository.entity.EventRepository;
import com.jhanp.gestioneventos.repository.entity.InvitationUserEventRepository;
import com.jhanp.gestioneventos.repository.entity.UserRepository;
import com.jhanp.gestioneventos.service.interfaces.IInvitationUserEventService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InvitationUserEventService implements IInvitationUserEventService {
    private static final Logger log = LoggerFactory.getLogger(InvitationUserEventService.class);

    private final InvitationUserEventRepository rep;
    private final EventRepository eventRep;
    private final UserRepository userRep;

    @Override
    public Page<InvitationUserEventResponseDTO> getAllInvitationUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return rep.findAll(pageable).map(Mapper::toResponseDTO);
    }

    @Override
    public Page<InvitationUserEventResponseDTO> getActiveInvitationUsers(int page, int size) {
        return rep.findByActiveTrue(PageRequest.of(page, size)).map(Mapper::toResponseDTO);
    }

    @Override
    public Page<InvitationUserEventResponseDTO> getInactiveInvitationUsers(int page, int size) {
        return rep.findByActiveFalse(PageRequest.of(page, size)).map(Mapper::toResponseDTO);
    }

    @Override
    @Transactional
    public InvitationUserEventResponseDTO createUserInvitation(InvitationUserEventRequestDTO invitationUserReq) {
        log.info("Creando invitación de usuario al evento ID: {}", invitationUserReq.getIdEvent());

        Event event = eventRep.findById(invitationUserReq.getIdEvent()).orElseThrow(() -> {
            log.warn("Evento no encontrado con ID: {}", invitationUserReq.getIdEvent());
            return new ResourceNotFoundException("Evento no encontrado con ID: " + invitationUserReq.getIdEvent());
        });

        User user = userRep.findById(invitationUserReq.getIdUser()).orElseThrow(() -> {
            log.warn("Usuario no encontrado con ID: {}", invitationUserReq.getIdUser());
            return new ResourceNotFoundException("Usuario no encontrado con ID: " + invitationUserReq.getIdUser());
        });

        InvitationUserEvent invitation = InvitationUserEvent.builder()
                .event(event)
                .user(user)
                .invitationStatus(invitationUserReq.getInvitationStatus())
                .sentDate(invitationUserReq.getSentDate())
                .active(invitationUserReq.getActive())
                .build();

        InvitationUserEventResponseDTO created = Mapper.toResponseDTO(rep.save(invitation));
        log.info("Invitación de usuario creada exitosamente");
        return created;
    }

    @Override
    @Transactional
    public InvitationUserEventResponseDTO updateUserInvitation(InvitationUserEventRequestDTO invitationUserReq) {
        log.info("Actualizando invitación de usuario con ID: {}", invitationUserReq.getId());

        InvitationUserEvent invitation = rep.findById(invitationUserReq.getId()).orElseThrow(() -> {
            log.warn("Invitación no encontrada con ID: {}", invitationUserReq.getId());
            return new ResourceNotFoundException("Invitación no encontrada con ID: " + invitationUserReq.getId());
        });

        Event event = eventRep.findById(invitationUserReq.getIdEvent()).orElseThrow(() -> {
            log.warn("Evento no encontrado con ID: {}", invitationUserReq.getIdEvent());
            return new ResourceNotFoundException("Evento no encontrado con ID: " + invitationUserReq.getIdEvent());
        });

        User user = userRep.findById(invitationUserReq.getIdUser()).orElseThrow(() -> {
            log.warn("Usuario no encontrado con ID: {}", invitationUserReq.getIdUser());
            return new ResourceNotFoundException("Usuario no encontrado con ID: " + invitationUserReq.getIdUser());
        });

        invitation.setEvent(event);
        invitation.setUser(user);
        invitation.setInvitationStatus(invitationUserReq.getInvitationStatus());
        invitation.setSentDate(invitationUserReq.getSentDate());
        invitation.setActive(invitationUserReq.getActive());

        InvitationUserEventResponseDTO updated = Mapper.toResponseDTO(rep.save(invitation));
        log.info("Invitación de usuario actualizada exitosamente con ID: {}", invitationUserReq.getId());
        return updated;
    }

    @Override
    @Transactional
    public Boolean deleteUserInvitation(Integer id) {
        log.info("Eliminando invitación de usuario con ID: {}", id);

        if (!rep.existsById(id)) {
            log.warn("Invitación de usuario no encontrada con ID: {}", id);
            throw new ResourceNotFoundException("Invitación de usuario no encontrada con ID: " + id);
        }
        rep.deleteById(id);
        log.info("Invitación de usuario eliminada exitosamente con ID: {}", id);
        return true;
    }
}
