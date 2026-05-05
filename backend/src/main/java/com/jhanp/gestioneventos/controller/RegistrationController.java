package com.jhanp.gestioneventos.controller;

import com.jhanp.gestioneventos.domain.view.UserRegistrationsView;
import com.jhanp.gestioneventos.dto.request.EventRoleRequestDTO;
import com.jhanp.gestioneventos.dto.request.RegistrationRequestDTO;
import com.jhanp.gestioneventos.dto.response.EventAccessResponseDTO;
import com.jhanp.gestioneventos.dto.response.EventRoleResponseDTO;
import com.jhanp.gestioneventos.dto.response.RegistrationResponseDTO;
import com.jhanp.gestioneventos.service.interfaces.IRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registrations")
@RequiredArgsConstructor
public class RegistrationController {
    private final IRegistrationService registrationService;

    @GetMapping
    public ResponseEntity<Page<RegistrationResponseDTO>> getAllRegistrations(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(registrationService.getAllRegistrations(page, size));
    }

    @GetMapping("/active")
    public ResponseEntity<Page<RegistrationResponseDTO>> getActiveRegistrations(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(registrationService.getActiveRegistrations(page, size));
    }

    @GetMapping("/inactive")
    public ResponseEntity<Page<RegistrationResponseDTO>> getInactiveRegistrations(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(registrationService.getInactiveRegistrations(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistrationResponseDTO> getRegistrationById(@PathVariable Integer id) {
        return ResponseEntity.ok(registrationService.getRegistrationById(id));
    }

    @GetMapping("/user/{identification}")
    public ResponseEntity<List<UserRegistrationsView>> getRegistrationsByUser(@PathVariable String identification) {
        return ResponseEntity.ok(registrationService.findRegistrationsByUserIdentificationNumber(identification));
    }

    @GetMapping("/event/{idEvent}/accesses")
    public ResponseEntity<List<EventAccessResponseDTO>> getAccessByEvent(@PathVariable Integer idEvent) {
        return ResponseEntity.ok(registrationService.getAccessByEvent(idEvent));
    }

    @PostMapping
    public ResponseEntity<RegistrationResponseDTO> createRegistration(@RequestBody RegistrationRequestDTO registrationReq) {
        return ResponseEntity.status(HttpStatus.CREATED).body(registrationService.createRegistration(registrationReq));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistrationResponseDTO> updateRegistration(
            @PathVariable Integer id,
            @RequestBody RegistrationRequestDTO registrationReq) {
        return ResponseEntity.ok(registrationService.updateRegistration(id, registrationReq));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistration(@PathVariable Integer id) {
        registrationService.deleteRegistration(id);
        return ResponseEntity.noContent().build();
    }

    // Event Roles
    @GetMapping("/event-roles")
    public ResponseEntity<List<EventRoleResponseDTO>> getAllEventRoles() {
        return ResponseEntity.ok(registrationService.getAllEventRoles());
    }

    @PostMapping("/event-roles")
    public ResponseEntity<EventRoleResponseDTO> createEventRole(@RequestBody EventRoleRequestDTO eventRoleReq) {
        return ResponseEntity.status(HttpStatus.CREATED).body(registrationService.createEventRole(eventRoleReq));
    }

    @PutMapping("/event-roles")
    public ResponseEntity<EventRoleResponseDTO> updateEventRole(@RequestBody EventRoleRequestDTO eventRoleReq) {
        return ResponseEntity.ok(registrationService.updateEventRole(eventRoleReq));
    }

    @DeleteMapping("/event-roles/{id}")
    public ResponseEntity<Void> deleteEventRole(@PathVariable Integer id) {
        registrationService.deleteEventRole(id);
        return ResponseEntity.noContent().build();
    }
}
