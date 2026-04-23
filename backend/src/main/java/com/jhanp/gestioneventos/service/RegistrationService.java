package com.jhanp.gestioneventos.service;

import com.jhanp.gestioneventos.dto.request.RegistrationRequestDTO;
import com.jhanp.gestioneventos.dto.response.EventAccessResponseDTO;
import com.jhanp.gestioneventos.dto.response.RegistrationResponseDTO;
import com.jhanp.gestioneventos.service.interfaces.IRegistrationService;
import org.springframework.data.domain.Page;

import java.util.List;

public class RegistrationService implements IRegistrationService {

    @Override
    public List<EventAccessResponseDTO> getAccessByEvent(Integer idEvent) {
        return List.of();
    }

    @Override
    public List<RegistrationResponseDTO> filterByIdUser(Long id) {
        return List.of();
    }

    @Override
    public List<RegistrationResponseDTO> filterByEvent(String nameEvent) {
        return List.of();
    }

    @Override
    public List<RegistrationResponseDTO> filterByBoth(Long identificacion, String nombreEvento) {
        return List.of();
    }

    @Override
    public Page<RegistrationResponseDTO> getAllRegistrations(int page, int size) {
        return null;
    }

    @Override
    public Page<RegistrationResponseDTO> getActiveRegistrations(int page, int size) {
        return null;
    }

    @Override
    public Page<RegistrationResponseDTO> getInactiveRegistrations(int page, int size) {
        return null;
    }

    @Override
    public RegistrationResponseDTO getRegistrationById(Integer id) {
        return null;
    }

    @Override
    public RegistrationResponseDTO createRegistration(RegistrationRequestDTO registrationReq) {
        return null;
    }

    @Override
    public RegistrationResponseDTO upgradeRegistration(Integer id, RegistrationRequestDTO registrationReq) {
        return null;
    }

    @Override
    public Boolean deleteRegistration(Integer id) {
        return null;
    }
}
