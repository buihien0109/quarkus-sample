package com.example.dao;

import com.example.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookDAO {
    List<Book> findAll();

    Optional<Book> findById(int id);

    Book addBook(Book book);

    Book updateBook(Book book);

    void deleteBook(int id);
}
