package com.jhanp.gestioneventos.controller;

import com.jhanp.gestioneventos.domain.view.EventsByOrganizationView;
import com.jhanp.gestioneventos.domain.view.UsersByOrganizationView;
import com.jhanp.gestioneventos.dto.request.OrganizationRequestDTO;
import com.jhanp.gestioneventos.dto.response.OrganizationResponseDTO;
import com.jhanp.gestioneventos.service.interfaces.IOrganizationService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
@RequiredArgsConstructor
public class OrganizationController {
    private final IOrganizationService organizationService;

    @GetMapping
    public ResponseEntity<Page<OrganizationResponseDTO>> getAllOrganizations(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(organizationService.getAllOrganizations(page, size));
    }

    @GetMapping("/active")
    public ResponseEntity<Page<OrganizationResponseDTO>> getActiveOrganizations(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(organizationService.getActiveOrganizations(page, size));
    }

    @GetMapping("/inactive")
    public ResponseEntity<Page<OrganizationResponseDTO>> getInactiveOrganizations(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(organizationService.getInactiveOrganizations(page, size));
    }

    @GetMapping("/search")
    public ResponseEntity<List<OrganizationResponseDTO>> searchOrganization(@RequestParam String q) {
        return ResponseEntity.ok(organizationService.searchOrganizationByIdentificationNumber(q));
    }

    @GetMapping("/{id}/users")
    public ResponseEntity<Page<UsersByOrganizationView>> getUsersByOrganization(
            @PathVariable Integer id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(organizationService.getUsersByOrganization(id, PageRequest.of(page, size)));
    }

    @GetMapping("/{id}/events")
    public ResponseEntity<Page<EventsByOrganizationView>> getEventsByOrganization(
            @PathVariable Integer id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(organizationService.getEventsByOrganization(id, PageRequest.of(page, size)));
    }

    @GetMapping("/user/{idUser}")
    public ResponseEntity<Page<UsersByOrganizationView>> getOrganizationByUser(
            @PathVariable Integer idUser,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(organizationService.getOrganizationByUser(idUser, PageRequest.of(page, size)));
    }

    @PostMapping
    public ResponseEntity<OrganizationResponseDTO> createOrganization(@RequestBody OrganizationRequestDTO organizationReq) {
        return ResponseEntity.status(HttpStatus.CREATED).body(organizationService.createOrganization(organizationReq));
    }

    @PutMapping
    public ResponseEntity<OrganizationResponseDTO> updateOrganization(@PathVariable Integer id, @RequestBody OrganizationRequestDTO organizationReq) {
        return ResponseEntity.ok(organizationService.updateOrganization(id, organizationReq));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable Integer id) {
        organizationService.deleteOrganization(id);
        return ResponseEntity.noContent().build();
    }
}
