package com.votacion.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.votacion.auth.dto.AuthResponse;
import com.votacion.auth.dto.LoginRequest;
import com.votacion.auth.dto.RegisterRequest;
import com.votacion.auth.service.IAuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private final IAuthService authService;

    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @Validated @RequestBody RegisterRequest request) {

        return ResponseEntity.ok(
                authService.register(request));
    }
    
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @Validated @RequestBody LoginRequest request) {

        return ResponseEntity.ok(
                authService.login(request));
    }
    
    @GetMapping("/profile")
    public ResponseEntity<String> profile() {

        return ResponseEntity.ok(
                "Acceso autorizado");
    }
}
