package com.jhanp.gestioneventos.dto.request;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventRequestDTO {
    private Integer id;
    private String name;
    private String description;
    private String address;
    private String place;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer capacity;
    private String accessRestriction;
    private String eventStatus;
    private Boolean active;

    private Integer idEventType;
    private Integer idOrganization;
}

