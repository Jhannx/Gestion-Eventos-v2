package com.jhanp.gestioneventos.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventResponseDTO {
    private Long id;
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

    private EventTypeResponseDTO eventType;
    private OrganizationResponseDTO organization;
    private List<EventAccessResponseDTO> eventAccessList;
}
