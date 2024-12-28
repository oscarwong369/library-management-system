package com.oscar.project.library_system.repository;

import com.oscar.project.library_system.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}