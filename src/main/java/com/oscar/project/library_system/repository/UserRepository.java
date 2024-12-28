package com.oscar.project.library_system.repository;

import com.oscar.project.library_system.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}