package com.jhanp.gestioneventos.service;

import com.jhanp.gestioneventos.domain.entity.OrganizationType;
import com.jhanp.gestioneventos.dto.request.OrganizationTypeRequestDTO;
import com.jhanp.gestioneventos.dto.response.OrganizationTypeResponseDTO;
import com.jhanp.gestioneventos.exception.DuplicateResourceException;
import com.jhanp.gestioneventos.exception.InvalidDataException;
import com.jhanp.gestioneventos.exception.ResourceNotFoundException;
import com.jhanp.gestioneventos.mapper.Mapper;
import com.jhanp.gestioneventos.repository.entity.OrganizationTypeRepository;
import com.jhanp.gestioneventos.service.interfaces.IOrganizationTypeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationTypeService implements IOrganizationTypeService {
    private static final Logger log = LoggerFactory.getLogger(OrganizationTypeService.class);

    private final OrganizationTypeRepository rep;

    @Override
    public List<OrganizationTypeResponseDTO> getAllOrganizationTypes() {
        log.info("Obteniendo todos los tipos de organización");
        return rep.findAll()
                .stream()
                .map(Mapper::toResponseDTO)
                .toList();
    }

    @Override
    public OrganizationTypeResponseDTO getOrganizationTypeById(Integer id) {
        log.info("Buscando tipo de organización con ID: {}", id);
        return rep.findById(id)
                .map(Mapper::toResponseDTO)
                .orElseThrow(() -> {
                    log.warn("Tipo de organización no encontrado con ID: {}", id);
                    return new ResourceNotFoundException("Tipo de organización no encontrado con ID: " + id);
                });
    }

    @Override
    @Transactional
    public OrganizationTypeResponseDTO createOrganizationType(OrganizationTypeRequestDTO organizationTypeReq) {
        log.info("Creando tipo de organización: {}", organizationTypeReq.getName());

        OrganizationType organizationType = OrganizationType.builder()
                .name(organizationTypeReq.getName())
                .description(organizationTypeReq.getDescription())
                .active(organizationTypeReq.getActive())
                .build();

        try {
            OrganizationTypeResponseDTO created = Mapper.toResponseDTO(rep.save(organizationType));
            log.info("Tipo de organización creado exitosamente con ID: {}", created.getId());
            return created;
        } catch (DataIntegrityViolationException e) {
            log.warn("Ya existe un tipo de organización con el nombre: {}", organizationTypeReq.getName());
            throw new DuplicateResourceException(
                    "Ya existe un tipo de organización con el nombre: " + organizationTypeReq.getName()
            );
        }
    }

    @Override
    @Transactional
    public OrganizationTypeResponseDTO updateOrganizationType(Integer id, OrganizationTypeRequestDTO organizationTypeReq) {
        log.info("Actualizando tipo de organización con ID: {}", id);

        OrganizationType organizationType = rep.findById(id)
                .orElseThrow(() -> {
                    log.warn("Tipo de organización no encontrado con ID: {}", id);
                    return new ResourceNotFoundException("Tipo de organización no encontrado con ID: " + id);
                });

        organizationType.setName(organizationTypeReq.getName());
        organizationType.setDescription(organizationTypeReq.getDescription());
        organizationType.setActive(organizationTypeReq.getActive());

        try {
            OrganizationTypeResponseDTO updated = Mapper.toResponseDTO(rep.save(organizationType));
            log.info("Tipo de organización actualizado exitosamente con ID: {}", id);
            return updated;
        } catch (DataIntegrityViolationException e) {
            log.warn("Ya existe un tipo de organización con el nombre: {}", organizationTypeReq.getName());
            throw new DuplicateResourceException(
                    "Ya existe un tipo de organización con el nombre: " + organizationTypeReq.getName()
            );
        }
    }

    @Override
    @Transactional
    public Boolean deleteOrganizationType(Integer id) {
        log.info("Eliminando tipo de organización con ID: {}", id);

        if (!rep.existsById(id)) {
            log.warn("Tipo de organización no encontrado con ID: {}", id);
            throw new ResourceNotFoundException(
                    "Tipo de organización no encontrado con ID: " + id
            );
        }

        try {
            rep.deleteById(id);
            log.info("Tipo de organización eliminado exitosamente con ID: {}", id);

            return true;

        } catch (DataIntegrityViolationException e) {
            log.error("Error al eliminar tipo de organización con ID: {}", id);

            throw new InvalidDataException("No se puede eliminar el tipo de organización porque tiene registros asociados");
        }
    }
}
