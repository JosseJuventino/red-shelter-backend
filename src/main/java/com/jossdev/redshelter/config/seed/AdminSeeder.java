package com.jossdev.redshelter.config.seed;

import com.jossdev.redshelter.features.user.User;
import com.jossdev.redshelter.features.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Slf4j
@Component
@RequiredArgsConstructor
public class AdminSeeder implements ApplicationRunner {
    private final AdminSeedProperties properties;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(ApplicationArguments args){
        if(!properties.enabled()){
            return;
        }

        if(properties.email() == null || properties.email().isBlank() || properties.password() == null){
            throw new IllegalStateException("Configuracion invalida del administrador");
        }

        var email = properties.email().trim().toLowerCase(Locale.ROOT);

        var existEmail = userRepository.existByEmail(email);

        if(existEmail) {
            throw new IllegalStateException("El usuario ya existe");
        }

        User admin = User.builder()
                .name(properties.name())
                .email(properties.email())
                .phone(properties.phone())
                .password(passwordEncoder.encode(properties.password()))
                .isPlatformAdmin(true)
                .isActive(true)
                .build();

        userRepository.save(admin);

        log.info("Admin creado");
    }
}
