package com.lucasbrasileiro.repository;

import com.lucasbrasileiro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
