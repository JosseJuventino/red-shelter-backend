package com.jossdev.redshelter.features.auth.dto;

public record AuthRequest(
        String email,
        String password
) {}
