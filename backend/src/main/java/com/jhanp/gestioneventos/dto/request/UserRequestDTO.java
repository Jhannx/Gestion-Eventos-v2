package com.jhanp.gestioneventos.dto.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {
    private Integer id;
    private String typeIdentification;
    private String numberIdentification;
    private String name;
    private String lastName;
    private String secondLastName;
    private String phone;
    private String email;
    private String password;
    private Boolean active;
}
