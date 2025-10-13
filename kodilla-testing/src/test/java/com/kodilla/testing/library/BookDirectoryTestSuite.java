package com.kodilla.testing.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @Test
    void testListBookWithConditionsReturnList() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);
        //When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");
        //Then
        assertEquals(4, theListOfBooks.size());
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    void testListBookWithConditionMorethan20() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);
        //When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book>  theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
        //Then
        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    void testListBookWithConditionFragmentShorterThan3() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        //When
        List<Book> theListOf10Books = bookLibrary.listBooksWithCondition("An");
        //Then
        assertEquals(0, theListOf10Books.size());
        verify(libraryDatabaseMock, never()).listBooksWithCondition("An");
    }

    @Test
    void testListBookInHandsOf0Books() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser user = new LibraryUser("John", "Kowalski", "12345" );
        when(bookLibrary.listBookInHandsOf(user)).thenReturn(new ArrayList<>());
        //When
        List<Book> result = bookLibrary.listBookInHandsOf(user);
        //Then
        assertEquals(0, result.size());
    }

    @Test
    void testListBookInHandsOf1Book() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser user = new LibraryUser("John", "Kowalski", "12345" );
        List<Book> book1 = List.of(new Book("Secrets of Alamo", "John Smith", 2000));
        when(bookLibrary.listBookInHandsOf(user)).thenReturn(book1);
        //When
        List<Book> result = bookLibrary.listBookInHandsOf(user);
        //Then
        assertEquals(1, result.size());
    }

    @Test
    void testListBookInHandsOf5Books() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser user = new LibraryUser("John", "Kowalski", "12345" );
        List<Book> fiveBooks = new ArrayList<>();
        fiveBooks.add(new Book("Secrets of Alamo", "John Smith", 2000));
        fiveBooks.add(new Book("Secretaries and Directors", "Dilbert Michigan", 2010));
        fiveBooks.add(new Book("Secrets of Java", "Steve Wolkowitz", 2016));
        fiveBooks.add(new Book("LOTR: The Two Towers", "Tolkien", 1930));
        fiveBooks.add(new Book("LOTR: The Return Of The King", "Tolkien", 1955));
        when(bookLibrary.listBookInHandsOf(user)).thenReturn(fiveBooks);
        //When
        List<Book> result = bookLibrary.listBookInHandsOf(user);
        //Then
        assertEquals(5, result.size());
    }
}
