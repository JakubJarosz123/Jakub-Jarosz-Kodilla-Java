package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class MedianAdapterTestSuite {

    @Test
    void testMedianPublicationYear() {
        //Given
        Set<Book> books = new HashSet<Book>();
        books.add(new Book("Author 1", "Title 1", 2000, "A"));
        books.add(new Book("Author 2", "Title 2", 1990, "B"));
        books.add(new Book("Author 3", "Title 3", 1999, "C"));
        books.add(new Book("Author 4", "Title 4", 2005, "D"));
        books.add(new Book("Author 5", "Title 5", 2010, "E"));

        MedianAdapter adapter = new MedianAdapter();
        //When
        int median = adapter.publicationYearMedian(books);
        //Then
        assertEquals(2000, median);
    }
}
