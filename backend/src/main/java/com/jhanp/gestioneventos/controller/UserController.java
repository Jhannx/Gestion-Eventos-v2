package com.jhanp.gestioneventos.controller;

import com.jhanp.gestioneventos.dto.request.UserRequestDTO;
import com.jhanp.gestioneventos.dto.response.UserResponseDTO;
import com.jhanp.gestioneventos.service.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @GetMapping
    public ResponseEntity<Page<UserResponseDTO>> getAllUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(userService.getAllUsers(page, size));
    }

    @GetMapping("/active")
    public ResponseEntity<Page<UserResponseDTO>> getActiveUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(userService.getActiveUsers(page, size));
    }

    @GetMapping("/inactive")
    public ResponseEntity<Page<UserResponseDTO>> getInactiveUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(userService.getInactiveUsers(page, size));
    }

    @GetMapping("/search")
    public ResponseEntity<List<UserResponseDTO>> searchById(@RequestParam String q) {
        return ResponseEntity.ok(userService.searchById(q));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userReq) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userReq));
    }

    @PutMapping
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Integer id,@RequestBody UserRequestDTO userReq) {
        return ResponseEntity.ok(userService.updateUser(id, userReq));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id, @RequestParam(defaultValue = "false") Boolean force) {
        userService.deleteUser(id, force);
        return ResponseEntity.noContent().build();
    }
}
