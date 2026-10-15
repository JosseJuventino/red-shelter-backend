package com.jossdev.redshelter.features.auth;


import com.jossdev.redshelter.config.security.JWTService;
import com.jossdev.redshelter.features.auth.dto.AuthRequest;
import com.jossdev.redshelter.features.auth.dto.AuthResult;
import com.jossdev.redshelter.features.user.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;

    @Transactional(readOnly = true)
    public AuthResult localLogin(@NonNull AuthRequest authRequest){
        var user = userRepository.findByEmail(authRequest.email())
                .filter(u -> u.getPassword() != null)
                .filter(u -> passwordEncoder.matches(authRequest.password(), u.getPassword()))
                .filter(u -> u.isActive())
                .orElseThrow(() -> new BadCredentialsException("Bad Credentials"));

        var accessToken = jwtService.issueAccessToken(user);

        return new AuthResult(accessToken, user.getEmail(), user.getId());
    }
}
