package com.oscar.project.library_system.service;

import com.oscar.project.library_system.entities.Book;
import com.oscar.project.library_system.entities.User;
import com.oscar.project.library_system.repository.BookRepository;
import com.oscar.project.library_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    private User getUser(long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    private Book getBook(long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    public Book borrowBook(long bookId, long userId) {
        Book book = getBook(bookId);
        User user = getUser(userId);

        if (book != null && user != null && !book.isBorrowed()) {
            book.setBorrowed(true);
            book.setBorrowedBy(user);
            return bookRepository.save(book);
        }
        return null;
    }

    public Book returnBook(long bookId) {
        Book book = getBook(bookId);
        if (book != null && book.isBorrowed()) {
            book.setBorrowed(false);
            book.setBorrowedBy(null);
            return bookRepository.save(book);
        }
        return null;
    }
}