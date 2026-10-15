package com.jossdev.redshelter.features.user;

import com.jossdev.redshelter.features.user.dto.CreateUser;
import com.jossdev.redshelter.features.user.dto.UserResponse;
import com.jossdev.redshelter.shared.exception.ConflictException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void createUser(CreateUser createUser){
        if(this.userRepository.existByEmail(createUser.email()))
            throw new ConflictException("Ya existe un usuario con ese correo.");

        var encodedPassword = this.passwordEncoder.encode(createUser.password());

        userRepository.save((User
                .builder()
                .name(createUser.name())
                .email(createUser.email()))
                .password(encodedPassword)
                .phone(createUser.phone())
                .isActive(true)
                .build()
        );
    }

    @Transactional(readOnly = true)
    public List<UserResponse> findAll() {
        return this.userRepository.findAllBy();
    }
}
