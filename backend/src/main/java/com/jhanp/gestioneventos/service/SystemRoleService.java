package com.jhanp.gestioneventos.service;

import com.jhanp.gestioneventos.domain.entity.SystemRole;
import com.jhanp.gestioneventos.dto.request.SystemRoleRequestDTO;
import com.jhanp.gestioneventos.dto.response.SystemRoleResponseDTO;
import com.jhanp.gestioneventos.exception.InvalidDataException;
import com.jhanp.gestioneventos.exception.ResourceNotFoundException;
import com.jhanp.gestioneventos.mapper.Mapper;
import com.jhanp.gestioneventos.repository.entity.SystemRoleRepository;
import com.jhanp.gestioneventos.service.interfaces.ISystemRoleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SystemRoleService implements ISystemRoleService {
    private static final Logger log = LoggerFactory.getLogger(SystemRoleService.class);

    private final SystemRoleRepository rep;

    @Override
    public List<SystemRoleResponseDTO> getAllSystemRoles() {
        return rep.findAll().stream().map(Mapper::toResponseDTO).toList();
    }

    @Override
    public List<SystemRoleResponseDTO> getActivesSystemRoles() {
        return rep.findByActiveTrue().stream().map(Mapper::toResponseDTO).toList();
    }

    @Override
    public SystemRoleResponseDTO getSystemRoleById(Integer id) {
        log.info("Buscando rol sistema con ID: {}", id);

        SystemRole systemRole = rep.findById(id).orElseThrow(() -> {
            log.warn("Rol sistema no encontrado con ID: {}", id);
            return new ResourceNotFoundException("Rol sistema no encontrado con ID: " + id);
        });

        return Mapper.toResponseDTO(systemRole);
    }

    @Override
    @Transactional
    public SystemRoleResponseDTO createSystemRole(SystemRoleRequestDTO systemRoleReq) {
        log.info("Creando rol sistema: {}", systemRoleReq.getName());

        SystemRole systemRole = SystemRole.builder()
                .name(systemRoleReq.getName())
                .description(systemRoleReq.getDescription())
                .active(systemRoleReq.getActive())
                .build();

        SystemRoleResponseDTO created = Mapper.toResponseDTO(rep.save(systemRole));
        log.info("Rol sistema creado exitosamente con ID: {}", created.getId());
        return created;
    }

    @Override
    @Transactional
    public SystemRoleResponseDTO updateSystemRole(Integer id, SystemRoleRequestDTO systemRoleReq) {
        log.info("Actualizando rol sistema con ID: {}", id);

        SystemRole systemRole = rep.findById(systemRoleReq.getId()).orElseThrow(() -> {
            log.warn("Rol sistema no encontrado con ID: {}", systemRoleReq.getId());
            return new ResourceNotFoundException("Rol sistema no encontrado con ID: " + systemRoleReq.getId());
        });

        systemRole.setName(systemRoleReq.getName());
        systemRole.setDescription(systemRoleReq.getDescription());
        systemRole.setActive(systemRoleReq.getActive());

        SystemRoleResponseDTO updated = Mapper.toResponseDTO(rep.save(systemRole));
        log.info("Rol sistema actualizado exitosamente con ID: {}", updated.getId());
        return updated;
    }

    @Override
    @Transactional
    public Boolean deleteSystemRole(Integer id) {
        log.info("Eliminando rol sistema con ID: {}", id);

        if (!rep.existsById(id)) {
            log.warn("Rol sistema no encontrado con ID: {}", id);
            throw new ResourceNotFoundException("Rol sistema no encontrado con ID: " + id);
        }

        try {
            rep.deleteById(id);
            log.info("Rol sistema eliminado exitosamente con ID: {}", id);
            return true;
        } catch (DataIntegrityViolationException e) {
            log.error("Error al eliminar rol sistema con ID {}: {}", id, e.getMessage());
            throw new InvalidDataException("No se puede eliminar el rol porque tiene usuarios asignados");
        }
    }
}
