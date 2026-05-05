package com.jhanp.gestioneventos.controller;

import com.jhanp.gestioneventos.domain.view.OccupationEventView;
import com.jhanp.gestioneventos.dto.request.EventAccessRequestDTO;
import com.jhanp.gestioneventos.dto.request.EventRequestDTO;
import com.jhanp.gestioneventos.dto.response.EventAccessResponseDTO;
import com.jhanp.gestioneventos.dto.response.EventResponseDTO;
import com.jhanp.gestioneventos.service.interfaces.IEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {

    private final IEventService eventService;

    @GetMapping
    public ResponseEntity<Page<EventResponseDTO>> getAllEvents(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(eventService.getAllEvents(page, size));
    }

    @GetMapping("/active")
    public ResponseEntity<Page<EventResponseDTO>> getActiveEvents(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(eventService.getActiveEvents(page, size));
    }

    @GetMapping("/inactive")
    public ResponseEntity<Page<EventResponseDTO>> getInactiveEvents(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(eventService.getInactiveEvents(page, size));
    }

    @GetMapping("/cancelled")
    public ResponseEntity<Page<EventResponseDTO>> getCancelledEvents(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(eventService.getCancelledEvents(page, size));
    }

    @GetMapping("/search")
    public ResponseEntity<List<EventResponseDTO>> searchEvent(@RequestParam String q) {
        return ResponseEntity.ok(eventService.searchEventById(q));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> getEventById(@PathVariable Integer id) {
        return ResponseEntity.ok(eventService.getEventById(id));
    }

    @GetMapping("/{id}/occupation")
    public ResponseEntity<OccupationEventView> getEventOccupation(@PathVariable Integer id) {
        return ResponseEntity.ok(eventService.getEventOccupation(id));
    }

    @PostMapping
    public ResponseEntity<EventResponseDTO> createEvent(@RequestBody EventRequestDTO eventReq) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.createEvent(eventReq));
    }

    @PutMapping
    public ResponseEntity<EventResponseDTO> updateEvent(@PathVariable Integer id, @RequestBody EventRequestDTO eventReq) {
        return ResponseEntity.ok(eventService.updateEvent(id, eventReq));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Integer id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    // Accesos
    @GetMapping("/{id}/accesses")
    public ResponseEntity<List<EventAccessResponseDTO>> getAccessByEvent(@PathVariable Integer id) {
        return ResponseEntity.ok(eventService.getAccessByEvent(id));
    }

    @GetMapping("/{idEvent}/accesses/{idAccess}")
    public ResponseEntity<EventAccessResponseDTO> getAccessById(
            @PathVariable Integer idEvent,
            @PathVariable Integer idAccess) {
        return ResponseEntity.ok(eventService.getAccessById(idEvent, idAccess));
    }

    @PostMapping("/{id}/accesses")
    public ResponseEntity<EventAccessResponseDTO> createEventAccess(
            @PathVariable Integer id,
            @RequestBody EventAccessRequestDTO eventAccessReq) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.createEventAccess(id, eventAccessReq));
    }

    @PutMapping("/{idEvent}/accesses/{idAccess}")
    public ResponseEntity<EventAccessResponseDTO> updateEventAccess(@PathVariable Integer idEvent, @PathVariable Integer idAccess, @RequestBody EventAccessRequestDTO eventAccessReq) {
        return ResponseEntity.ok(eventService.updateEventAccess(idEvent, idAccess, eventAccessReq));
    }

    @DeleteMapping("/{idEvent}/accesses/{idAccess}")
    public ResponseEntity<Void> deleteEventAccess(@PathVariable Integer idEvent, @PathVariable Integer idAccess) {
        eventService.deleteEventAccess(idEvent, idAccess);
        return ResponseEntity.noContent().build();
    }
}
