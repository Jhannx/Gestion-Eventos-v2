package com.jhanp.gestioneventos.controller;

import com.jhanp.gestioneventos.dto.request.SystemRoleRequestDTO;
import com.jhanp.gestioneventos.dto.response.SystemRoleResponseDTO;
import com.jhanp.gestioneventos.service.interfaces.ISystemRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/system-roles")
@RequiredArgsConstructor
public class SystemRoleController {
    private final ISystemRoleService systemRoleService;

    @GetMapping
    public ResponseEntity<List<SystemRoleResponseDTO>> getAllSystemRoles() {
        return ResponseEntity.ok(systemRoleService.getAllSystemRoles());
    }

    @GetMapping("/active")
    public ResponseEntity<List<SystemRoleResponseDTO>> getActiveSystemRoles() {
        return ResponseEntity.ok(systemRoleService.getActivesSystemRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SystemRoleResponseDTO> getSystemRoleById(@PathVariable Integer id) {
        return ResponseEntity.ok(systemRoleService.getSystemRoleById(id));
    }

    @PostMapping
    public ResponseEntity<SystemRoleResponseDTO> createSystemRole(@RequestBody SystemRoleRequestDTO systemRoleReq) {
        return ResponseEntity.status(HttpStatus.CREATED).body(systemRoleService.createSystemRole(systemRoleReq));
    }

    @PutMapping
    public ResponseEntity<SystemRoleResponseDTO> updateSystemRole(@PathVariable Integer id, @RequestBody SystemRoleRequestDTO systemRoleReq) {
        return ResponseEntity.ok(systemRoleService.updateSystemRole(id, systemRoleReq));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSystemRole(@PathVariable Integer id) {
        systemRoleService.deleteSystemRole(id);
        return ResponseEntity.noContent().build();
    }
}
