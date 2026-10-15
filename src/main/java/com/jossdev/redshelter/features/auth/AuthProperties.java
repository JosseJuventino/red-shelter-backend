package com.jossdev.redshelter.features.auth;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.Duration;

@ConfigurationProperties(prefix = "app.auth")
public record AuthProperties(
        @DefaultValue("15m") Duration accessTtl,
        @DefaultValue("12h") Duration refreshTtlWeb,
        @DefaultValue("30d") Duration refreshTtlMobile,
        @DefaultValue("5") int maxSessions,
        @DefaultValue("30d") Duration cleanupRetention
) { }
