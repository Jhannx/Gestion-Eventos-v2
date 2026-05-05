package com.jhanp.gestioneventos.dto.request;

import lombok.*;

import java.time.Instant;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationRequestDTO {
    private Integer id;
    private Instant RegistrationDate;
    private String registrationStatus;
    private String attendance;
    private Boolean active;

    private Integer idUser;
    private Integer idEventAccess;
}

