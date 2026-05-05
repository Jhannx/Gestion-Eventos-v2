package com.jhanp.gestioneventos.controller;

import com.jhanp.gestioneventos.dto.request.EventTypeRequestDTO;
import com.jhanp.gestioneventos.dto.response.EventTypeResponseDTO;
import com.jhanp.gestioneventos.service.interfaces.IEventTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event-type")
@RequiredArgsConstructor
public class EventTypeController {
    private final IEventTypeService eventTypeService;

    @GetMapping
    public ResponseEntity<List<EventTypeResponseDTO>> getAllEventTypes() {
        List<EventTypeResponseDTO> result = eventTypeService.getAllEventTypes();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/active")
    public ResponseEntity<List<EventTypeResponseDTO>> getActiveEventTypes() {
        List<EventTypeResponseDTO> result = eventTypeService.getActiveEventTypes();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/inactive")
    public ResponseEntity<List<EventTypeResponseDTO>> getInactiveEventTypes() {
        List<EventTypeResponseDTO> result = eventTypeService.getInactiveEventTypes();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/search")
    public ResponseEntity<List<EventTypeResponseDTO>> searchEventType(@RequestParam String q) {

        return ResponseEntity.ok(eventTypeService.searchEventTypeById(q));
    }

    @PostMapping
    public ResponseEntity<EventTypeResponseDTO> createEventType(@RequestBody EventTypeRequestDTO requestDTO) {

        EventTypeResponseDTO created = eventTypeService.createEventType(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventTypeResponseDTO> updateEventType(@PathVariable Integer id, @RequestBody EventTypeRequestDTO requestDTO) {

        EventTypeResponseDTO updated = eventTypeService.updateEventType(id, requestDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEventType(@PathVariable Integer id) {

        boolean deleted = eventTypeService.deleteEventType(id);

        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.noContent().build();
    }
}
