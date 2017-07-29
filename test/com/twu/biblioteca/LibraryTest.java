package com.twu.biblioteca;


import org.junit.*;

import java.io.PrintStream;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LibraryTest {
  private PrintStream printStream;
  private List<Book> bookList;
  private Library library;
  private Book book1;

  @Before
  public void setUp() {
    printStream = mock(PrintStream.class);
    bookList = new ArrayList<Book>();
    book1 = mock(Book.class);
    bookList.add(book1);

    library = new Library(printStream,bookList);
  }

  @Test
  public void should_list_one_book_when_book_list_has_only_one() {
    library.displayBooks();
    verify(book1).getBookDetail();
  }

  @Test
  public void should_list_books() {
    Book book2 = mock(Book.class);
    bookList.add(book2);
    library.displayBooks();
    for (Book book : bookList) {
      verify(book).getBookDetail();
    }
  }
}
