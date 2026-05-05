package com.jhanp.gestioneventos.service;

import com.jhanp.gestioneventos.domain.entity.Organization;
import com.jhanp.gestioneventos.domain.entity.OrganizationType;
import com.jhanp.gestioneventos.domain.view.EventsByOrganizationView;
import com.jhanp.gestioneventos.domain.view.UsersByOrganizationView;
import com.jhanp.gestioneventos.dto.request.OrganizationRequestDTO;
import com.jhanp.gestioneventos.dto.response.OrganizationResponseDTO;
import com.jhanp.gestioneventos.exception.DuplicateResourceException;
import com.jhanp.gestioneventos.exception.InvalidDataException;
import com.jhanp.gestioneventos.exception.ResourceNotFoundException;
import com.jhanp.gestioneventos.mapper.Mapper;
import com.jhanp.gestioneventos.repository.entity.OrganizationRepository;
import com.jhanp.gestioneventos.repository.entity.OrganizationTypeRepository;
import com.jhanp.gestioneventos.repository.entity.UserOrganizationRepository;
import com.jhanp.gestioneventos.repository.view.EventsByOrganizationViewRepository;
import com.jhanp.gestioneventos.repository.view.UsersByOrganizationViewRepository;
import com.jhanp.gestioneventos.service.interfaces.IOrganizationService;
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
public class OrganizationService implements IOrganizationService {
    private static final Logger log = LoggerFactory.getLogger(OrganizationService.class);

    private final OrganizationRepository rep;
    private final OrganizationTypeRepository organizationTypeRep;
    private final UsersByOrganizationViewRepository usersByOrganizationRep;
    private final EventsByOrganizationViewRepository eventsByOrganizationRep;

    @Override
    public Page<OrganizationResponseDTO> getAllOrganizations(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return rep.findAll(pageable).map(Mapper::toResponseDTO);
    }

    @Override
    public Page<OrganizationResponseDTO> getActiveOrganizations(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return rep.findByActiveTrue(pageable).map(Mapper::toResponseDTO);
    }

    @Override
    public Page<OrganizationResponseDTO> getInactiveOrganizations(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return rep.findByActiveFalse(pageable).map(Mapper::toResponseDTO);
    }

    @Override
    public Page<UsersByOrganizationView> getUsersByOrganization(Integer idOrganization, Pageable pageable) {
        log.info("Obteniendo usuarios de la organización con ID: {}", idOrganization);

        if (!rep.existsById(idOrganization)) {
            log.warn("Organización no encontrada con ID: {}", idOrganization);
            throw new ResourceNotFoundException("Organización no encontrada con ID: " + idOrganization);
        }

        return usersByOrganizationRep.findByIdOrganization(idOrganization, pageable);
    }

    @Override
    public Page<EventsByOrganizationView> getEventsByOrganization(Integer idOrganization, Pageable pageable) {
        log.info("Obteniendo eventos de la organización con ID: {}", idOrganization);

        if (!rep.existsById(idOrganization)) {
            log.warn("Organización no encontrada con ID: {}", idOrganization);
            throw new ResourceNotFoundException("Organización no encontrada con ID: " + idOrganization);
        }

        return eventsByOrganizationRep.findByIdOrganization(idOrganization, pageable);
    }

    @Override
    public Page<UsersByOrganizationView> getOrganizationByUser(Integer idUser, Pageable pageable) {
        log.info("Obteniendo organizaciones del usuario con ID: {}", idUser);
        return usersByOrganizationRep.findByIdUser(idUser, pageable);
    }

    @Override
    public List<OrganizationResponseDTO> searchOrganizationByIdentificationNumber(String q) {
        return rep.findByNameContainingIgnoreCase(q)
                .stream()
                .map(Mapper::toResponseDTO)
                .toList();
    }

    @Override
    @Transactional
    public OrganizationResponseDTO createOrganization(OrganizationRequestDTO organizationReq) {
        log.info("Creando organización: {}", organizationReq.getName());

        Organization organization = Organization.builder()
                .name(organizationReq.getName())
                .active(organizationReq.getActive())
                .build();

        if (organizationReq.getIdOrganizationType() != null) {
            organization.setOrganizationType(organizationTypeRep.findById(organizationReq.getIdOrganizationType()).orElseThrow(() -> {
                        log.warn("Tipo de organización no encontrado con ID: {}", organizationReq.getIdOrganizationType());
                        return new ResourceNotFoundException("Tipo de organización no encontrado con ID: " + organizationReq.getIdOrganizationType());
                    })
            );
        }

        OrganizationResponseDTO created = Mapper.toResponseDTO(rep.save(organization));
        log.info("Organización creada exitosamente con ID: {}", created.getId());
        return created;
    }

    @Override
    @Transactional
    public OrganizationResponseDTO updateOrganization(Integer id, OrganizationRequestDTO organizationReq) {
        log.info("Actualizando organización con ID: {}", id);

        Organization organization = rep.findById(organizationReq.getId().intValue()).orElseThrow(() -> {
            log.warn("Organización no encontrada con ID: {}", organizationReq.getId());
            return new ResourceNotFoundException("Organización no encontrada con ID: " + organizationReq.getId());
        });

        organization.setName(organizationReq.getName());
        organization.setActive(organizationReq.getActive());

        if (organizationReq.getIdOrganizationType() != null) {
            organization.setOrganizationType(
                    organizationTypeRep.findById(organizationReq.getIdOrganizationType()).orElseThrow(() -> {
                        log.warn("Tipo de organización no encontrado con ID: {}", organizationReq.getIdOrganizationType());
                        return new ResourceNotFoundException("Tipo de organización no encontrado con ID: " + organizationReq.getIdOrganizationType());
                    })
            );
        }

        OrganizationResponseDTO updated = Mapper.toResponseDTO(rep.save(organization));
        log.info("Organización actualizada exitosamente con ID: {}", updated.getId());
        return updated;
    }

    @Override
    @Transactional
    public Boolean deleteOrganization(Integer id) {
        log.info("Desactivando organización con ID: {}", id);

        if (!rep.existsById(id)) {
            log.warn("Organización no encontrada con ID: {}", id);
            throw new ResourceNotFoundException("Organización no encontrada con ID: " + id);
        }
        rep.deactivateOrganization(id);
        log.info("Organización desactivada exitosamente con ID: {}", id);
        return true;
    }
}
