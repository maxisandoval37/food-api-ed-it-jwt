package ar.dev.maxisandoval.foodapieditjwt.controller;

import ar.dev.maxisandoval.foodapieditjwt.dto.*;
import ar.dev.maxisandoval.foodapieditjwt.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody AuthRequest request) {
        String token = authService.register(request.getUsername(), request.getPassword());
        return new AuthResponse(token);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        String token = authService.authenticate(request.getUsername(), request.getPassword());
        return new AuthResponse(token);
    }
}