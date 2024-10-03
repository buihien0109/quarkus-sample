package com.example.service;

import com.example.model.Book;
import com.example.model.BookDTO;
import com.example.model.BookResponse;

import java.util.List;

public interface BookService {
    List<BookResponse> getAllBooks();

    BookResponse getBookById(int id);

    BookResponse addBook(BookDTO book);

    BookResponse updateBook(int id, BookDTO book);

    void deleteBook(int id);
}
