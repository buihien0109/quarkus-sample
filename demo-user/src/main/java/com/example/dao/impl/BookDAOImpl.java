package com.example.dao.impl;

import com.example.dao.BookDAO;
import com.example.database.BookDB;
import com.example.model.Book;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookDAOImpl implements BookDAO {
    @Override
    public List<Book> findAll() {
        return BookDB.books;
    }

    @Override
    public Optional<Book> findById(int id) {
        return BookDB.books.stream()
                .filter(book -> book.getId() == id)
                .findFirst();
    }

    @Override
    public Book addBook(Book book) {
        book.setId(createId());
        BookDB.books.add(book);
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        BookDB.books.stream()
                .filter(b -> b.getId() == book.getId())
                .forEach(b -> {
                    b.setTitle(book.getTitle());
                    b.setAuthor(book.getAuthor());
                    b.setYear(book.getYear());
                });
        return book;
    }

    @Override
    public void deleteBook(int id) {
        BookDB.books.removeIf(book -> book.getId() == id);
    }

    private int createId() {
        if (BookDB.books.isEmpty()) {
            return 1;
        }
        return BookDB.books.stream()
                .map(Book::getId)
                .max(Integer::compare)
                .orElse(0) + 1;
    }
}
