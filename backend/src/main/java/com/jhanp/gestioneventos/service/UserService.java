package com.jhanp.gestioneventos.service;

import com.jhanp.gestioneventos.domain.entity.User;
import com.jhanp.gestioneventos.dto.request.UserRequestDTO;
import com.jhanp.gestioneventos.dto.response.UserResponseDTO;
import com.jhanp.gestioneventos.exception.ResourceNotFoundException;
import com.jhanp.gestioneventos.mapper.Mapper;
import com.jhanp.gestioneventos.repository.entity.UserRepository;
import com.jhanp.gestioneventos.repository.view.ActiveUsersViewRepository;
import com.jhanp.gestioneventos.service.interfaces.IUserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository rep;
    private final ActiveUsersViewRepository activeUsersRep;

    @Override
    public Page<UserResponseDTO> getAllUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return rep.findAll(pageable).map(Mapper::toResponseDTO);
    }

    @Override
    public Page<UserResponseDTO> getActiveUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return activeUsersRep.findAll(pageable).map(Mapper::toResponseDTO);
    }

    @Override
    public Page<UserResponseDTO> getInactiveUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return rep.findUserByActiveFalse(pageable).map(Mapper::toResponseDTO);
    }

    @Override
    public List<UserResponseDTO> searchById(String q) {
        return rep.findByIdentificationNumber(q)
                .stream()
                .map(Mapper::toResponseDTO)
                .toList();
    }

    @Override
    public UserResponseDTO getUserById(Integer id) {
        log.info("Buscando usuario con ID: {}", id);

        User user = rep.findById(id).orElseThrow(() -> {
            log.warn("Usuario no encontrado con ID: {}", id);
            return new ResourceNotFoundException("Usuario no encontrado con ID: " + id);
        });
        return Mapper.toResponseDTO(user);
    }

    @Override
    @Transactional
    public UserResponseDTO createUser(UserRequestDTO userReq) {
        log.info("Creando usuario: {}", userReq.getName());

        User user = User.builder()
                .identificationType(userReq.getTypeIdentification())
                .identificationNumber(userReq.getNumberIdentification())
                .firstName(userReq.getName())
                .lastName(userReq.getLastName())
                .secondLastName(userReq.getSecondLastName())
                .phone(userReq.getPhone())
                .email(userReq.getEmail())
                .password(userReq.getPassword())
                .active(userReq.getActive())
                .build();

        UserResponseDTO created = Mapper.toResponseDTO(rep.save(user));
        log.info("Usuario creado exitosamente con ID: {}", created.getIdUser());
        return created;
    }

    @Override
    @Transactional
    public UserResponseDTO updateUser(Integer id, UserRequestDTO userReq) {
        log.info("Actualizando al usuario con número de identificación : {}", userReq.getNumberIdentification());

        User user = rep.findById(id).orElseThrow(() -> {
            log.warn("Usuario no encontrado con ID: {}", userReq.getId());
            return new ResourceNotFoundException("Usuario no encontrado con ID: " + userReq.getId());
        });
        user.setIdentificationType(userReq.getTypeIdentification());
        user.setIdentificationNumber(userReq.getNumberIdentification());
        user.setFirstName(userReq.getName());
        user.setLastName(userReq.getLastName());
        user.setSecondLastName(userReq.getSecondLastName());
        user.setPhone(userReq.getPhone());
        user.setEmail(userReq.getEmail());
        user.setPassword(userReq.getPassword());
        user.setActive(userReq.getActive());

        UserResponseDTO updated = Mapper.toResponseDTO(rep.save(user));
        log.info("Usuario actualizado exitosamente con ID: {}", updated.getIdUser());
        return updated;
    }

    @Override
    @Transactional
    public Boolean deleteUser(Integer id, Boolean force) {
        log.info("Desactivando usuario con ID: {}", id);

        if (!rep.existsById(id)) {
            log.warn("Usuario no encontrado con ID: {}", id);
            throw new ResourceNotFoundException("Usuario no encontrado con ID: " + id);
        }
        rep.deactivateUser(id, force);
        log.info("Usuario desactivado exitosamente con ID: {}", id);
        return true;
    }
}
