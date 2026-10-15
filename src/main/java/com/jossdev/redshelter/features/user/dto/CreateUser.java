package com.jossdev.redshelter.features.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.jspecify.annotations.NonNull;
import jakarta.validation.constraints.Email;

public record CreateUser(
        @NotBlank(message = "El nombre es obligatorio")
        String name,

        @NotBlank(message = "El correo es obligatorio")
        @Email(message = "El correo noe s valido")
        String email,

        @NotBlank(message = "El telefono es obligatorio")
        String phone,

        @NotBlank(message = "La contraseña es obligatoria")
        @Size(min = 8, message = "La contraseña debe tener como minimo 8 caracteres.")
        String password
) {}
