package com.example.model;

public class Book {
    int id;
    String title;
    String author;
    int year;

    public Book() {
        System.out.println("Book no constructor called");
    }

    public Book(String title, String author, int year) {
        System.out.println("Book 3 constructor called");
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Book(int id, String title, String author, int year) {
        System.out.println("Book all constructor called");
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
