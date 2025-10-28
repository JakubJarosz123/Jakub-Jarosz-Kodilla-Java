package com.kodilla.stream.bookStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book {
    private String title;
    private List<String> authors;


    public Book(String title, List<String> authors) {
        this.title = title;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                '}';
    }
}
