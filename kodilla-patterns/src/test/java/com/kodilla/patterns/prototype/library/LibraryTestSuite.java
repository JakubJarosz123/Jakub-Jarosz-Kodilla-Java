package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given
        Book toReadBook = new Book("LOTR: The Two Towers", "J.R.R Tolkien", LocalDate.of(1920, 07, 04));
        Book readBook = new Book("LOTR: Fellowship OF The Ring", "J.R.R Tolkien", LocalDate.of(1950, 07, 04));
        Book notGoingToReadBook = new Book("LOTR: The Return Of The King", "J.R.R Tolkien", LocalDate.of(1955, 07, 04));

        Library library = new Library("New Library");
        library.getBooks().add(toReadBook);
        library.getBooks().add(readBook);
        library.getBooks().add(notGoingToReadBook);

        //Shallow copy
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Cloned Library");
        } catch  (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //Deep Copy
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Deep Cloned Library");
        } catch  (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().remove(toReadBook);
        //Then
        System.out.println(library.getBooks());
        System.out.println(clonedLibrary.getBooks());
        System.out.println(deepClonedLibrary.getBooks());
        assertEquals(2, library.getBooks().size());
        assertEquals(2, clonedLibrary.getBooks().size());
        assertEquals(3, deepClonedLibrary.getBooks().size());
        assertEquals(clonedLibrary.getBooks(), library.getBooks());
        assertNotEquals(deepClonedLibrary.getBooks(), clonedLibrary.getBooks());
    }
}
