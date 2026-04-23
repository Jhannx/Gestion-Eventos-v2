package com.jhanp.gestioneventos.service.interfaces;

import com.jhanp.gestioneventos.dto.request.EventAccessRequestDTO;
import com.jhanp.gestioneventos.dto.response.EventAccessResponseDTO;
import org.springframework.data.domain.Page;

public interface IEventAccessService {
    Page<EventAccessResponseDTO> getAccess(int  page, int size);
    EventAccessResponseDTO getAccessById(Integer id);
    EventAccessResponseDTO createAccess(EventAccessRequestDTO eventAccessReq);
    EventAccessResponseDTO updateAccess(Integer id, EventAccessRequestDTO eventAccessReq);
    boolean deleteAccess(Integer id);
}
