package com.jhanp.gestioneventos.controller;

import com.jhanp.gestioneventos.dto.request.InvitationUserEventRequestDTO;
import com.jhanp.gestioneventos.dto.response.InvitationUserEventResponseDTO;
import com.jhanp.gestioneventos.service.interfaces.IInvitationUserEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invitations/users")
@RequiredArgsConstructor
public class InvitationUserEventController {
    private final IInvitationUserEventService invitationUserEventService;

    @GetMapping
    public ResponseEntity<Page<InvitationUserEventResponseDTO>> getAllInvitations(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(invitationUserEventService.getAllInvitationUsers(page, size));
    }

    @GetMapping("/active")
    public ResponseEntity<Page<InvitationUserEventResponseDTO>> getActiveInvitations(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(invitationUserEventService.getActiveInvitationUsers(page, size));
    }

    @GetMapping("/inactive")
    public ResponseEntity<Page<InvitationUserEventResponseDTO>> getInactiveInvitations(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(invitationUserEventService.getInactiveInvitationUsers(page, size));
    }

    @PostMapping
    public ResponseEntity<InvitationUserEventResponseDTO> createInvitation(@RequestBody InvitationUserEventRequestDTO invitationReq) {
        return ResponseEntity.status(HttpStatus.CREATED).body(invitationUserEventService.createUserInvitation(invitationReq));
    }

    @PutMapping
    public ResponseEntity<InvitationUserEventResponseDTO> updateInvitation(@RequestBody InvitationUserEventRequestDTO invitationReq) {
        return ResponseEntity.ok(invitationUserEventService.updateUserInvitation(invitationReq));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvitation(@PathVariable Integer id) {
        invitationUserEventService.deleteUserInvitation(id);
        return ResponseEntity.noContent().build();
    }
}
