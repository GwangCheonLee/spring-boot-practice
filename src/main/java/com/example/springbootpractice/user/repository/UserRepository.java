package com.example.springbootpractice.user.repository;

import com.example.springbootpractice.user.entity.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID>, UserRepositoryCustom {

    User findByEmail(String email);
}
