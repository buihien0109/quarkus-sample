package com.example.database;

import com.example.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDB {
    public static List<Book> books = new ArrayList<>(List.of(
            new Book(1, "Java Programming", "John Doe", 2021),
            new Book(2, "Python Programming", "Jane Doe", 2020),
            new Book(3, "C Programming", "Alice Doe", 2019),
            new Book(4, "C++ Programming", "Bob Doe", 2018),
            new Book(5, "Kotlin Programming", "Eve Doe", 2017)
    ));
}
