package com.modakbul.domain.user.repository;

import com.modakbul.domain.user.entity.User;
import com.modakbul.domain.user.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByIdAndUserStatus(Long id, UserStatus status);
}
