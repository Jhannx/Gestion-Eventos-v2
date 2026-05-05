package com.jhanp.gestioneventos.service;

import com.jhanp.gestioneventos.domain.entity.Event;
import com.jhanp.gestioneventos.domain.entity.InvitationOrganizationEvent;
import com.jhanp.gestioneventos.domain.entity.Organization;
import com.jhanp.gestioneventos.dto.request.InvitationOrganizationEventRequestDTO;
import com.jhanp.gestioneventos.dto.response.InvitationOrganizationEventResponseDTO;
import com.jhanp.gestioneventos.exception.ResourceNotFoundException;
import com.jhanp.gestioneventos.mapper.Mapper;
import com.jhanp.gestioneventos.repository.entity.EventRepository;
import com.jhanp.gestioneventos.repository.entity.InvitationOrganizationEventRepository;
import com.jhanp.gestioneventos.repository.entity.OrganizationRepository;
import com.jhanp.gestioneventos.service.interfaces.IInvitationOrganizationEventService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

    @Service
    @RequiredArgsConstructor
    public class InvitationOrganizationEventService implements IInvitationOrganizationEventService {
        private static final Logger log = LoggerFactory.getLogger(InvitationOrganizationEventService.class);

        private final InvitationOrganizationEventRepository rep;
        private final EventRepository eventRep;
        private final OrganizationRepository organizationRep;

        @Override
        public Page<InvitationOrganizationEventResponseDTO> getAllInvitationOrganizations(int page, int size) {
            Pageable pageable = PageRequest.of(page, size);
            return rep.findAll(pageable).map(Mapper::toResponseDTO);
        }

        @Override
        public Page<InvitationOrganizationEventResponseDTO> getActiveInvitationOrganizations(int page, int size) {
            return rep.findByActiveTrue(PageRequest.of(page, size)).map(Mapper::toResponseDTO);
        }

        @Override
        public Page<InvitationOrganizationEventResponseDTO> getInactiveInvitationOrganizations(int page, int size) {
            return rep.findByActiveFalse(PageRequest.of(page, size)).map(Mapper::toResponseDTO);
        }

        @Override
        @Transactional
        public InvitationOrganizationEventResponseDTO createOrganizationInvitation(InvitationOrganizationEventRequestDTO invitationOrganizationReq) {
            log.info("Creando invitación de organización al evento ID: {}", invitationOrganizationReq.getIdEvent());

            Event event = eventRep.findById(invitationOrganizationReq.getIdEvent()).orElseThrow(() -> {
                log.warn("Evento no encontrado con ID: {}", invitationOrganizationReq.getIdEvent());
                return new ResourceNotFoundException("Evento no encontrado con ID: " + invitationOrganizationReq.getIdEvent());
            });

            Organization organization = organizationRep.findById(invitationOrganizationReq.getIdOrganization()).orElseThrow(() -> {
                log.warn("Organización no encontrada con ID: {}", invitationOrganizationReq.getIdOrganization());
                return new ResourceNotFoundException("Organización no encontrada con ID: " + invitationOrganizationReq.getIdOrganization());
            });

            InvitationOrganizationEvent invitation = InvitationOrganizationEvent.builder()
                    .event(event)
                    .organization(organization)
                    .invitationStatus(invitationOrganizationReq.getInvitationStatus())
                    .sentDate(invitationOrganizationReq.getSentDate())
                    .active(invitationOrganizationReq.getActive())
                    .build();

            InvitationOrganizationEventResponseDTO created = Mapper.toResponseDTO(rep.save(invitation));
            log.info("Invitación de organización creada exitosamente");
            return created;
        }

        @Override
        @Transactional
        public InvitationOrganizationEventResponseDTO updateOrganizationInvitation(InvitationOrganizationEventRequestDTO invitationOrganizationReq) {
            log.info("Actualizando invitación de organización con ID: {}", invitationOrganizationReq.getId());

            InvitationOrganizationEvent invitation = rep.findById(invitationOrganizationReq.getId()).orElseThrow(() -> {
                log.warn("Invitación de organización no encontrada con ID: {}", invitationOrganizationReq.getId());
                return new ResourceNotFoundException("Invitación de organización no encontrada con ID: " + invitationOrganizationReq.getId());
            });

            Event event = eventRep.findById(invitationOrganizationReq.getIdEvent()).orElseThrow(() -> {
                log.warn("Evento no encontrado con ID: {}", invitationOrganizationReq.getIdEvent());
                return new ResourceNotFoundException("Evento no encontrado con ID: " + invitationOrganizationReq.getIdEvent());
            });

            Organization organization = organizationRep.findById(invitationOrganizationReq.getIdOrganization()).orElseThrow(() -> {
                log.warn("Organización no encontrada con ID: {}", invitationOrganizationReq.getIdOrganization());
                return new ResourceNotFoundException("Organización no encontrada con ID: " + invitationOrganizationReq.getIdOrganization());
            });

            invitation.setEvent(event);
            invitation.setOrganization(organization);
            invitation.setInvitationStatus(invitationOrganizationReq.getInvitationStatus());
            invitation.setSentDate(invitationOrganizationReq.getSentDate());
            invitation.setActive(invitationOrganizationReq.getActive());

            InvitationOrganizationEventResponseDTO updated = Mapper.toResponseDTO(rep.save(invitation));
            log.info("Invitación de organización actualizada exitosamente con ID: {}", invitationOrganizationReq.getId());
            return updated;
        }

        @Override
        @Transactional
        public Boolean deleteOrganizationInvitation(Integer id) {
            log.info("Eliminando invitación de organización con ID: {}", id);

            if (!rep.existsById(id)) {
                log.warn("Invitación de organización no encontrada con ID: {}", id);
                throw new ResourceNotFoundException("Invitación de organización no encontrada con ID: " + id);
            }
            rep.deleteById(id);
            log.info("Invitación de organización eliminada exitosamente con ID: {}", id);
            return true;
        }
    }
