package com.jhanp.gestioneventos.service.interfaces;

import com.jhanp.gestioneventos.dto.request.RegistrationRequestDTO;
import com.jhanp.gestioneventos.dto.response.EventAccessResponseDTO;
import com.jhanp.gestioneventos.dto.response.RegistrationResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IRegistrationService {
    List<EventAccessResponseDTO> getAccessByEvent (Integer idEvent);
    List<RegistrationResponseDTO> filterByIdUser(Integer id);
    List<RegistrationResponseDTO> filterByEvent(String nameEvent);
    List<RegistrationResponseDTO> filterByBoth(Integer identificacion, String nombreEvento);

    Page<RegistrationResponseDTO> getAllRegistrations(int  page, int size);
    Page<RegistrationResponseDTO> getActiveRegistrations(int  page, int size);
    Page<RegistrationResponseDTO> getInactiveRegistrations(int  page, int size);
    RegistrationResponseDTO getRegistrationById(Integer id);
    RegistrationResponseDTO createRegistration(RegistrationRequestDTO registrationReq);
    RegistrationResponseDTO upgradeRegistration(Integer id, RegistrationRequestDTO registrationReq);
    Boolean deleteRegistration(Integer id);
}

