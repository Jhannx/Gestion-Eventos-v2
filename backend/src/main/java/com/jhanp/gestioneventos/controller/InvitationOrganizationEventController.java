package com.jhanp.gestioneventos.controller;

import com.jhanp.gestioneventos.dto.request.InvitationOrganizationEventRequestDTO;
import com.jhanp.gestioneventos.dto.response.InvitationOrganizationEventResponseDTO;
import com.jhanp.gestioneventos.service.interfaces.IInvitationOrganizationEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invitations/organizations")
@RequiredArgsConstructor
public class InvitationOrganizationEventController {
    private final IInvitationOrganizationEventService invitationOrganizationEventService;

    @GetMapping
    public ResponseEntity<Page<InvitationOrganizationEventResponseDTO>> getAllInvitations(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(invitationOrganizationEventService.getAllInvitationOrganizations(page, size));
    }

    @GetMapping("/active")
    public ResponseEntity<Page<InvitationOrganizationEventResponseDTO>> getActiveInvitations(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(invitationOrganizationEventService.getActiveInvitationOrganizations(page, size));
    }

    @GetMapping("/inactive")
    public ResponseEntity<Page<InvitationOrganizationEventResponseDTO>> getInactiveInvitations(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(invitationOrganizationEventService.getInactiveInvitationOrganizations(page, size));
    }

    @PostMapping
    public ResponseEntity<InvitationOrganizationEventResponseDTO> createInvitation(@RequestBody InvitationOrganizationEventRequestDTO invitationReq) {
        return ResponseEntity.status(HttpStatus.CREATED).body(invitationOrganizationEventService.createOrganizationInvitation(invitationReq));
    }

    @PutMapping
    public ResponseEntity<InvitationOrganizationEventResponseDTO> updateInvitation(@RequestBody InvitationOrganizationEventRequestDTO invitationReq) {
        return ResponseEntity.ok(invitationOrganizationEventService.updateOrganizationInvitation(invitationReq));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvitation(@PathVariable Integer id) {
        invitationOrganizationEventService.deleteOrganizationInvitation(id);
        return ResponseEntity.noContent().build();
    }
}
