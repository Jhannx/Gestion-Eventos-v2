package com.jhanp.gestioneventos.dto.request;

import java.time.Instant;

public class RegistrationRequestDTO {
    private Instant RegistrationDate;
    private String registrationStatus;
    private String attendance;

    private Long idUser;
    private Long idEventAccess;
}
