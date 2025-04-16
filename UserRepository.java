package com.pollsystem.pollservice.repository;

import com.pollsystem.pollservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
