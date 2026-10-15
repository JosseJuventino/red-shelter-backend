package com.jossdev.redshelter.features.user;


import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Builder
@Getter @Setter
@Entity @Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;
    private String email;
    private String phone;
    private boolean isPlatformAdmin;
    private boolean isActive;
}
