package com.jossdev.redshelter.features.auth;

import com.jossdev.redshelter.features.auth.dto.AuthRequest;
import com.jossdev.redshelter.features.auth.dto.AuthResponse;
import com.jossdev.redshelter.features.auth.dto.AuthResult;
import com.jossdev.redshelter.shared.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@Valid @RequestBody @NonNull AuthRequest login) {
        log.info("Request login for {}", login.email());
        AuthResult result = authService.localLogin(login);

        return respond(result, "login sucessful");
    }

    private ResponseEntity<ApiResponse<AuthResponse>> respond(AuthResult result, String message) {
        return ResponseEntity.ok(ApiResponse.success(message,
                new AuthResponse(result.accessToken(), result.email(), result.userId())));
    }
}
