package com.jhanp.gestioneventos.controller;

import com.jhanp.gestioneventos.dto.request.OrganizationTypeRequestDTO;
import com.jhanp.gestioneventos.dto.response.OrganizationTypeResponseDTO;
import com.jhanp.gestioneventos.service.interfaces.IOrganizationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organization-type")
@RequiredArgsConstructor
public class OrganizationTypeController {
    private final IOrganizationTypeService organizationTypeService;
    
    @GetMapping
    public ResponseEntity<List<OrganizationTypeResponseDTO>> getAllOrganizationTypes() {
        List<OrganizationTypeResponseDTO> response = organizationTypeService.getAllOrganizationTypes();
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<OrganizationTypeResponseDTO> getOrganizationTypeById(@PathVariable Integer id) {

        OrganizationTypeResponseDTO response = organizationTypeService.getOrganizationTypeById(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<OrganizationTypeResponseDTO> createOrganizationType(@RequestBody OrganizationTypeRequestDTO requestDTO) {

        OrganizationTypeResponseDTO created = organizationTypeService.createOrganizationType(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizationTypeResponseDTO> updateOrganizationType(
            @PathVariable Integer id, @RequestBody OrganizationTypeRequestDTO requestDTO) {

        OrganizationTypeResponseDTO updated = organizationTypeService.updateOrganizationType(id, requestDTO);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganizationType(@PathVariable Integer id) {

        boolean deleted = organizationTypeService.deleteOrganizationType(id);

        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.noContent().build();
    }


}
