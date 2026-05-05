package com.jhanp.gestioneventos.controller;

import com.jhanp.gestioneventos.dto.request.AccessTypeRequestDTO;
import com.jhanp.gestioneventos.dto.response.AccessTypeResponseDTO;
import com.jhanp.gestioneventos.service.interfaces.IAccessTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/access-type")
@RequiredArgsConstructor
public class AccessTypeController {
    private final IAccessTypeService accessTypeService;

    @GetMapping
    public ResponseEntity<List<AccessTypeResponseDTO>> getAllAccessTypes() {
        List<AccessTypeResponseDTO> result = accessTypeService.getAllAccessTypes();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/active")
    public ResponseEntity<List<AccessTypeResponseDTO>> getActiveAccessTypes() {
        List<AccessTypeResponseDTO> result = accessTypeService.getActiveAccessTypes();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/inactive")
    public ResponseEntity<List<AccessTypeResponseDTO>> getInactiveAccessTypes() {
        List<AccessTypeResponseDTO> result = accessTypeService.getInactiveAccessTypes();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<AccessTypeResponseDTO> createAccessType(@RequestBody AccessTypeRequestDTO accessTypeRequestDTO) {
        AccessTypeResponseDTO created = accessTypeService.createAccessType(accessTypeRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccessTypeResponseDTO> updateAccessType(
            @PathVariable Integer id,
            @RequestBody AccessTypeRequestDTO accessTypeRequestDTO) {
        AccessTypeResponseDTO updated = accessTypeService.updateAccessType(id, accessTypeRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccessType(@PathVariable Integer id) {
        boolean deleted = accessTypeService.deleteAccessType(id);

        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.noContent().build();
    }
}
