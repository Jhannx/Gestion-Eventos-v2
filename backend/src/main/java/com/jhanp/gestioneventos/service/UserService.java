package com.jhanp.gestioneventos.service;

import com.jhanp.gestioneventos.dto.request.UserRequestDTO;
import com.jhanp.gestioneventos.dto.response.UserResponseDTO;
import com.jhanp.gestioneventos.service.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    @Override
    public Page<UserResponseDTO> getAllUsers(int page, int size) {
        return null;
    }

    @Override
    public Page<UserResponseDTO> getActiveUsers(int page, int size) {
        return null;
    }

    @Override
    public Page<UserResponseDTO> getInactiveUsers(int page, int size) {
        return null;
    }

    @Override
    public List<UserResponseDTO> searchById(String q) {
        return List.of();
    }

    @Override
    public UserResponseDTO getUserById(Integer id) {
        return null;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO userReq) {
        return null;
    }

    @Override
    public UserResponseDTO updateUser(UserRequestDTO userReq) {
        return null;
    }

    @Override
    public Boolean deleteUser(Integer id, Boolean force) {
        return null;
    }
}

