package com.jossdev.redshelter.features.auth.dto;

public record AuthResult(
        String accessToken,
        String email,
        Long userId
) {}
