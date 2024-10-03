package com.example.resource;

import com.example.model.BookDTO;
import com.example.model.BookResponse;
import com.example.service.BookService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Random;

@Path("/api/books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    private final BookService bookService;
    private final Random random;

    @Inject
    public BookResource(BookService bookService, Random random) {
        this.bookService = bookService;
        this.random = random;
    }

    @GET
    public List<BookResponse> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GET
    @Path("/{id}")
    public BookResponse getBookById(@PathParam("id") int id) {
        return bookService.getBookById(id);
    }

    @POST
    public BookResponse addBook(@Valid BookDTO book) {
        return bookService.addBook(book);
    }

    @PUT
    @Path("/{id}")
    public BookResponse updateBook(@PathParam("id") int id, @Valid BookDTO book) {
        return bookService.updateBook(id, book);
    }

    @DELETE
    @Path("/{id}")
    public void deleteBook(@PathParam("id") int id) {
        bookService.deleteBook(id);
    }

    @GET
    @Path("/random")
    public int randomNumber() {
        return random.nextInt(1000);
    }
}
