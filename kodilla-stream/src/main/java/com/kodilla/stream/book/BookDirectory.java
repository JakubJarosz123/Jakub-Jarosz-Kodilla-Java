package com.kodilla.stream.book;

import java.util.ArrayList;
import java.util.List;

public final class BookDirectory {

    private final List<Book> theBookList = new ArrayList<>();

    public BookDirectory() {
        theBookList.add(new Book("LOTR: The Two Towers", "Tolkien", 2000, "001"));
        theBookList.add(new Book("Hobbit", "Tolkien", 2005, "002"));
        theBookList.add(new Book("LOTR: The Fellowship Of The Ring", "Tolkien", 2009, "003"));
        theBookList.add(new Book("Journey To The Centre Of The Earth", "Julius Werne", 2018, "004"));
        theBookList.add(new Book("The Exorcist", "John Murphy", 2019, "005"));
    }

    public List<Book> getList() {
        return new ArrayList<>(theBookList);
    }
}
