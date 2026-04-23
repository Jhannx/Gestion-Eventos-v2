package com.jhanp.gestioneventos.dto.response;

import java.time.Instant;

public class RegistrationResponseDTO {
    private Long id;
    private Instant RegistrationDate;
    private String registrationStatus;
    private String attendance;
    private Boolean active;

    private UserResponseDTO user;
    private EventAccessResponseDTO eventAccess;

}
