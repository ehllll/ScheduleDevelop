package com.example.scheduledevelop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.scheduledevelop.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
