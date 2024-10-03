package com.example.config;

import com.example.model.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import java.util.Random;

@ApplicationScoped
public class BeanConfig {
    @Produces
    public Book createBook() {
        return new Book(1, "Java Programming", "John Doe", 2021);
    }

    @Produces
    public Random createRandom() {
        return new Random();
    }
}
