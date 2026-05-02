package com.jhanp.gestioneventos.service.interfaces;

import com.jhanp.gestioneventos.dto.request.UserRequestDTO;
import com.jhanp.gestioneventos.dto.response.UserResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IUserService {
    Page<UserResponseDTO> getAllUsers(int page, int size);
    Page<UserResponseDTO> getActiveUsers(int page, int size);
    Page<UserResponseDTO> getInactiveUsers(int page, int size);
    List<UserResponseDTO> searchById(String q);
    UserResponseDTO getUserById(Integer id);
    UserResponseDTO createUser(UserRequestDTO userReq);
    UserResponseDTO updateUser(UserRequestDTO userReq);
    Boolean deleteUser(Integer id, Boolean force);
}

