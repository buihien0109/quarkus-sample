package com.example.service.impl;

import com.example.dao.BookDAO;
import com.example.exception.type.BadRequestException;
import com.example.exception.type.NotFoundException;
import com.example.model.Book;
import com.example.model.BookDTO;
import com.example.model.BookResponse;
import com.example.service.BookService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class BookServiceImpl implements BookService {
    private final BookDAO bookDAO;

    @Inject
    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }


    @Override
    public List<BookResponse> getAllBooks() {
        return bookDAO.findAll().stream()
                .map(this::convertToResponse)
                .toList();
    }

    @Override
    public BookResponse getBookById(int id) {
        Book book = bookDAO.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found"));
        return convertToResponse(book);
    }

    @Override
    public BookResponse addBook(BookDTO book) {
        // add validation for title
        if (book.getTitle().length() < 5) {
            throw new BadRequestException("Title must have at least 5 characters");
        }

        Book newBook = convertToEntity(book);
        Book addedBook = bookDAO.addBook(newBook);
        return convertToResponse(addedBook);
    }

    @Override
    public BookResponse updateBook(int id, BookDTO book) {
        Book existingBook = bookDAO.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found"));

        // add validation for year
        if (book.getYear() < 0) {
            throw new BadRequestException("Year must be greater than 0");
        }

        Book newBook = convertToEntity(book);
        newBook.setId(id);
        Book updatedBook = bookDAO.updateBook(newBook);
        return convertToResponse(updatedBook);
    }

    @Override
    public void deleteBook(int id) {
        bookDAO.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found"));

        bookDAO.deleteBook(id);
    }

    private BookResponse convertToResponse(Book book) {
        return new BookResponse(book.getId(), book.getTitle(), book.getAuthor(), book.getYear());
    }

    private Book convertToEntity(BookDTO bookDTO) {
        return new Book(bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getYear());
    }
}
