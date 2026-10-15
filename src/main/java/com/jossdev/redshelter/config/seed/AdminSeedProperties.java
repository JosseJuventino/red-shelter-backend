package com.jossdev.redshelter.config.seed;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "seed.admin")
public record AdminSeedProperties(
        boolean enabled,
        String email,
        String password,
        String name,
        String phone
) {}
