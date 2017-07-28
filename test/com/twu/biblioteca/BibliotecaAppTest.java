package com.twu.biblioteca;


import org.junit.*;

import java.io.PrintStream;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BibliotecaAppTest {
    private PrintStream printStream;
    private List<Book> bookList;
    private BibliotecaApp bibliotecaApp;
    private Book book1;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        bookList = new ArrayList<Book>();
        book1 = mock(Book.class);
        bookList.add(book1);

        bibliotecaApp = new BibliotecaApp(printStream, bookList);
    }

    @Test
    public void should_list_one_book_when_book_list_has_only_one() {
        bibliotecaApp.displayBooks();
        verify(book1).getBookDetail();
    }
}
