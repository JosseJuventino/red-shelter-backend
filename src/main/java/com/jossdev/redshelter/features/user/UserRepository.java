package com.jossdev.redshelter.features.user;

import com.jossdev.redshelter.features.user.dto.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT COUNT(*) >= 1 FROM User u WHERE u.email = :email")
    Boolean existByEmail(String email);

    List<UserResponse> findAllBy();
}
