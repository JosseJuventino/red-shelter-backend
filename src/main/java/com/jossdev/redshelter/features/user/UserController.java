package com.jossdev.redshelter.features.user;

import com.jossdev.redshelter.features.user.dto.CreateUser;
import com.jossdev.redshelter.features.user.dto.UserResponse;
import com.jossdev.redshelter.shared.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Operation(summary = "Crear un nuevo usuario")
    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createUser(@Valid @RequestBody CreateUser user){
        this.userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Usuario creado"));
    }

    @Operation(summary = "Obtener los usuarios de la base de datos")
    @GetMapping()
    public ResponseEntity<ApiResponse<List<UserResponse>>> getUsers() {
        return ResponseEntity.ok(ApiResponse.success("Usuarios obtenidos", this.userService.findAll()));
    }

}
