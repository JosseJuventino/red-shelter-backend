package com.jossdev.redshelter.config.security;

import com.jossdev.redshelter.features.auth.AuthProperties;
import com.jossdev.redshelter.features.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class JWTService {

    private final JwtEncoder jwtEncoder;
    private final AuthProperties authProperties;

    public String issueAccessToken(User user){
        var now = Instant.now();
        var claims = JwtClaimsSet.builder()
                .issuer("http://localhost:3000")
                .issuedAt(now)
                .expiresAt(now.plus(authProperties.accessTtl()))
                .subject(String.valueOf(user.getId()))
                .claim("email", user.getEmail());

        JwsHeader header = JwsHeader.with(MacAlgorithm.HS256).build();

        return jwtEncoder.encode(JwtEncoderParameters.from(header, claims.build())).getTokenValue();
    }
}
