package com.jossdev.redshelter.features.user.dto;

public record UserResponse (
        Long id,
        String name,
        String email,
        String phone,
        boolean isActive
) {}
